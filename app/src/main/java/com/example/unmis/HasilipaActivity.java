package com.example.unmis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HasilipaActivity extends AppCompatActivity {
    private LinearLayout mainn;
    Integer nilai, totalNilai;
    TextView txtHasilipa;
    Button btnMainmenu, btnPenjipa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasilipa);
        mainn = findViewById(R.id.mainmenu);
        btnPenjipa = findViewById(R.id.btnPenjipa);
        tangkap();
        kenalan();totalNilai = 100 * nilai / 30 ;
        txtHasilipa.setText("Jawaban Benar Anda adalah " + nilai + "/30" + "\nNilai Anda adalah " + totalNilai);
        btnMainmenu = (Button)findViewById(R.id.btnMainmenu);

        btnMainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HasilipaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnPenjipa = (Button)findViewById(R.id.btnPenjipa);

        btnPenjipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HasilipaActivity.this,PenjipaActivity.class);
                startActivity(intent);
            }
        });
    }


    private void kenalan() { txtHasilipa = (TextView)findViewById(R.id.txtHasilipa);
    }
    private void tangkap() {
        nilai = getIntent().getIntExtra("nilai",0);
        Log.i("Tangkapan Sukses", String.valueOf(nilai));
    }
}

