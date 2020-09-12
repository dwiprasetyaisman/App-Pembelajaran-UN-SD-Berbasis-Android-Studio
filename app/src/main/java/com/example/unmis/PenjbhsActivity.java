package com.example.unmis;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.media.MediaPlayer;

public class PenjbhsActivity extends AppCompatActivity {
    private LinearLayout mainn;
    Button btnMainmenu;
    MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjbhs);
        mainn = findViewById(R.id.mainmenu);

        audio = MediaPlayer.create(this, R.raw.penjbhs);
        audio.setLooping(false);
        audio.setVolume(1, 1);
        audio.start();

        btnMainmenu = (Button)findViewById(R.id.btnMainmenu);

        btnMainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PenjbhsActivity.this, MainActivity.class);
                startActivity(intent);
                audio.stop();

            }
        });


    }
}