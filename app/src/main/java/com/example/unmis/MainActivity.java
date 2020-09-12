package com.example.unmis;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private LinearLayout ipaa, bahasaa, mtka, tentanga;
    EditText nameEditText;
    Button cariBtn;
    MediaPlayer audio;

    @Override
    public void onBackPressed() {
        audio = MediaPlayer.create(this, R.raw.penutup);
        audio.setLooping(false);
        audio.setVolume(1, 1);
        audio.start();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Apakah Anda Ingin Keluar?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                moveTaskToBack(true);
                audio.stop();
                finish();
                System.exit(0);
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                audio.stop();
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audio = MediaPlayer.create(this, R.raw.pembuka);
        audio.setLooping(false);
        audio.setVolume(1, 1);
        audio.start();

        ipaa = findViewById(R.id.ipa);
        bahasaa = findViewById(R.id.bahasa);
        mtka = findViewById(R.id.mtk);
        tentanga = findViewById(R.id.tentang);

        ipaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                Intent intent= new Intent(MainActivity.this, SoalIpa1Activity.class);
                startActivity(intent);
                audio.stop();
            }
        });

        bahasaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, SoalBhs1Activity.class);
                startActivity(intent);
                audio.stop();
            }
        });

        tentanga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, TentangActivity.class);
                startActivity(intent);
                audio.stop();
            }
        });

        mtka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, SoalMtk1Activity.class);
                startActivity(intent);
                audio.stop();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent= new Intent(MainActivity.this, BantuanActivity.class);
            startActivity(intent);
            audio.stop();
        }
        return super.onOptionsItemSelected(item);
    }
}