package com.google.ar.university.project.app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.CamcorderProfile;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;

import com.google.ar.core.Anchor;
import com.google.ar.core.Config;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.core.Session;
import com.google.ar.university.AnchorNode;
import com.google.ar.university.ArSceneView;
import com.google.ar.university.Node;
import com.google.ar.university.SceneView;
import com.google.ar.university.Sceneform;
import com.google.ar.university.math.Vector3;
import com.google.ar.university.rendering.ModelRenderable;
import com.google.ar.university.rendering.Renderable;
import com.google.ar.university.rendering.ViewRenderable;
import com.google.ar.university.ux.ArFragment;
import com.google.ar.university.ux.BaseArFragment;
import com.google.ar.university.ux.TransformableNode;

import java.lang.ref.WeakReference;

public class ModelActivity extends AppCompatActivity implements
        FragmentOnAttachListener,
        BaseArFragment.OnTapArPlaneListener,
        BaseArFragment.OnSessionConfigurationListener,
        ArFragment.OnViewCreatedListener {

    private ArFragment arFragment;
    private Renderable model;
    private ViewRenderable viewRenderable;
    private VideoRecorder videoRecorder;
    private boolean recording=false;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        setContentView(R.layout.activity_main);
        getSupportFragmentManager().addFragmentOnAttachListener(this);

        if (savedInstanceState == null) {
            if (Sceneform.isSupported(this)) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.arFragment, ArFragment.class, null)
                        .commit();
            }
        }
//implementation of menu buttons, and what they are supposed to do
        final ImageButton menuButton = findViewById(R.id.imageButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(ModelActivity.this,menuButton);
                popup.getMenuInflater().inflate(R.menu.popup_menu,popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch(menuItem.getItemId()) {
                            case R.id.one:
                                Intent intent = new Intent(ModelActivity.this,ModelList.class);
                                startActivity(intent);
                                return true;
                            case R.id.two:
                                intent = new Intent(ModelActivity.this, VideoGallery.class);
                                startActivity(intent);
                                return true;
                            default:
                                return ModelActivity.super.onOptionsItemSelected(menuItem);
                        }
                    }
                });
                popup.show();
            }
        });
        loadModels();

        //initializing video recorder essentials (might not work,might delete later)
//        videoRecorder = new VideoRecorder();
//        videoRecorder.setSceneView(arFragment.getArSceneView());
//        int orientation = getResources().getConfiguration().orientation;
//        videoRecorder.setVideoQuality(CamcorderProfile.QUALITY_HIGH,orientation);

         startButton = findViewById(R.id.button4);
         startButton.setEnabled(false);
         startButton.setTextColor(Color.GREEN);
         startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(videoRecorder==null){
                    videoRecorder = new VideoRecorder();
                }
                    videoRecorder.onToggleRecord();

                if(recording) {
                    startButton.setText("Start");
                    startButton.setTextColor(Color.GREEN);
                    recording=false;
                } else {

                    startButton.setText("Stop");
                    startButton.setTextColor(Color.RED);
                    recording=true;
                }
            }
        });

//        final Button stopButton = findViewById(R.id.button5);
//        stopButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(true){
//                    videoRecorder.onToggleRecord();
//                    Toast toast=Toast.makeText(getApplicationContext(),"Stopped recording" + videoRecorder.isRecording(),
//                            Toast.LENGTH_LONG);
//                    toast.show();
//                    recording=false;
//                }
//            }
//        });
    }

    @Override
    public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        if (fragment.getId() == R.id.arFragment) {
            arFragment = (ArFragment) fragment;
            arFragment.setOnSessionConfigurationListener(this);
            arFragment.setOnViewCreatedListener(this);
            arFragment.setOnTapArPlaneListener(this);
        }
    }

    @Override
    public void onSessionConfiguration(Session session, Config config) {
        if (session.isDepthModeSupported(Config.DepthMode.AUTOMATIC)) {
            config.setDepthMode(Config.DepthMode.AUTOMATIC);
        }
    }

    @Override
    public void onViewCreated(ArSceneView arSceneView) {
        arFragment.setOnViewCreatedListener(null);

        // Fine adjust the maximum frame rate
        arSceneView.setFrameRateFactor(SceneView.FrameRate.FULL);
    }

    public void loadModels() {
        Intent intent= getIntent();
        Bundle b = intent.getExtras();
        String modelName = (String) b.get("modelName");

        WeakReference<ModelActivity> weakActivity = new WeakReference<>(this);
        ModelRenderable.builder()
                .setSource(this,Uri.parse("models/"+modelName))
                .setIsFilamentGltf(true)
                .setAsyncLoadEnabled(true)
                .build()
                .thenAccept(model -> {
                    ModelActivity activity = weakActivity.get();
                    if (activity != null) {
                        activity.model = model;
                    }
                })
                .exceptionally(throwable -> {
                    Toast.makeText(
                            this, "Unable to load model", Toast.LENGTH_LONG).show();
                    return null;
                });
        ViewRenderable.builder()
                .setView(this, R.layout.view_model_title)
                .build()
                .thenAccept(viewRenderable -> {
                    ModelActivity activity = weakActivity.get();
                    if (activity != null) {
                        activity.viewRenderable = viewRenderable;
                    }
                })
                .exceptionally(throwable -> {
                    Toast.makeText(this, "Unable to load model", Toast.LENGTH_LONG).show();
                    return null;
                });


    }

    @Override
    public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
        if (model == null || viewRenderable == null) {
            Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create the Anchor.
        Anchor anchor = hitResult.createAnchor();
        AnchorNode anchorNode = new AnchorNode(anchor);
        anchorNode.setParent(arFragment.getArSceneView().getScene());

        // Create the transformable model and add it to the anchor.
        TransformableNode model = new TransformableNode(arFragment.getTransformationSystem());
        model.setParent(anchorNode);
        model.setRenderable(this.model)
                .animate(true).start();
        model.select();

        Node titleNode = new Node();
        titleNode.setParent(model);
        titleNode.setEnabled(false);
        titleNode.setLocalPosition(new Vector3(0.0f, 1.0f, 0.0f));
        titleNode.setRenderable(viewRenderable);
        titleNode.setEnabled(true);

        if(videoRecorder==null) {
            videoRecorder = new VideoRecorder();
        }
        videoRecorder.setSceneView(arFragment.getArSceneView());
        int orientation = getResources().getConfiguration().orientation;
        videoRecorder.setVideoQuality(CamcorderProfile.QUALITY_HIGH,orientation);
        startButton.setEnabled(true);

    }


}
