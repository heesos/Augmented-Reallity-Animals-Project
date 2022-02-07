package com.google.ar.university.project.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Intent intent= getIntent();
        Bundle b = intent.getExtras();
        String modelName = (String) b.get("movieName");

        VideoView videoView=findViewById(R.id.videoView);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setVideoURI(Uri.parse(modelName));
        videoView.setMediaController(mediaController);
        videoView.start();

    }

}