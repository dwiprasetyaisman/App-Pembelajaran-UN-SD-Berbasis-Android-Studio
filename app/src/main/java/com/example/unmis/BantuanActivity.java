package com.example.unmis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.media.MediaPlayer;

public class BantuanActivity extends AppCompatActivity {
    private LinearLayout mainn;
    TextView txtTentang;
    Button btnMainmenu;
    MediaPlayer audio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);
        mainn = findViewById(R.id.mainmenu);
        btnMainmenu = (Button) findViewById(R.id.btnMainmenu);

        audio = MediaPlayer.create(this, R.raw.bantuan);
        audio.setLooping(false);
        audio.setVolume(1, 1);
        audio.start();

        btnMainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BantuanActivity.this, MainActivity.class);
                startActivity(intent);
                audio.stop();
            }
        });
    }
}

