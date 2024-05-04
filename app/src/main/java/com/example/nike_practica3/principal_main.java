package com.example.nike_practica3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class principal_main extends AppCompatActivity {

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, R.string.inicio, Toast.LENGTH_SHORT).show();
    }
    VideoView idVideoView;
    Button btnVolverLogin, btnAcerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnVolverLogin = findViewById(R.id.btnVolverLogin);
        btnAcerca = findViewById(R.id.btnAcerca);

        idVideoView = findViewById(R.id.idVideoView);


        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.nike;

        idVideoView.setVideoURI(Uri.parse(videoPath));
        idVideoView.start();

        idVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                idVideoView.start();
            }
        });

        btnVolverLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), acerca_main.class);
                startActivity(intent);
            }
        });
    }
}