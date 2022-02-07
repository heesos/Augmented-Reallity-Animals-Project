package com.google.ar.university.project.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ModelList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_list);

        ImageButton dogButton = findViewById(R.id.dogButton);
        dogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModelList.this,ModelActivity.class);
                intent.putExtra("modelName","dog.glb");
                startActivity(intent);
            }
        });

        ImageButton catButton = findViewById(R.id.catButton);
        catButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModelList.this,ModelActivity.class);
                intent.putExtra("modelName","cat.glb");
                startActivity(intent);
            }
        });

        ImageButton tigerButton = findViewById(R.id.tigerButton);
        tigerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModelList.this,ModelActivity.class);
                intent.putExtra("modelName","model.glb");
                startActivity(intent);
            }
        });
        ImageButton ratButton = findViewById(R.id.ratButton);
        ratButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModelList.this,ModelActivity.class);
                intent.putExtra("modelName","rat.glb");
                startActivity(intent);
            }
        });
        ImageButton unicornButton = findViewById(R.id.unicornButton);
        unicornButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModelList.this,ModelActivity.class);
                intent.putExtra("modelName","unicorn.glb");
                startActivity(intent);
            }
        });
        ImageButton dinoButton = findViewById(R.id.dinoButton);
        dinoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModelList.this,ModelActivity.class);
                intent.putExtra("modelName","dino.glb");
                startActivity(intent);
            }
        });
    }
}