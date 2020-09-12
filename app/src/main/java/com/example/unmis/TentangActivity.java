package com.example.unmis;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.media.MediaPlayer;
public class TentangActivity extends AppCompatActivity {
    private LinearLayout mainn;
    TextView txtTentang;
    Button btnMainmenu;
    MediaPlayer audio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
        mainn = findViewById(R.id.mainmenu);
        btnMainmenu = (Button)findViewById(R.id.btnMainmenu);

        audio = MediaPlayer.create(this, R.raw.tentang);
        audio.setLooping(false);
        audio.setVolume(1, 1);
        audio.start();

        btnMainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TentangActivity.this, MainActivity.class);
                startActivity(intent);
                audio.stop();
            }
        });
    }
}

