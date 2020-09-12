package com.example.unmis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HasilmtkActivity extends AppCompatActivity {
    private LinearLayout mainn;
    Integer nilai, totalNilai;
    TextView txtHasilmtk;
    Button btnMainmenu, btnPenjmtk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasilmtk);
        mainn = findViewById(R.id.mainmenu);
        btnPenjmtk = findViewById(R.id.btnPenjmtk);
        tangkap();
        kenalan();totalNilai = 100 * nilai / 30;
        txtHasilmtk.setText("Jawaban Benar Anda adalah " + nilai + "/30" + "\nNilai Anda adalah " + totalNilai);
        btnMainmenu = (Button)findViewById(R.id.btnMainmenu);

        btnMainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HasilmtkActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnPenjmtk = (Button)findViewById(R.id.btnPenjmtk);

        btnPenjmtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HasilmtkActivity.this,PenjmtkActivity.class);
                startActivity(intent);
            }
        });
    }


    private void kenalan() { txtHasilmtk = (TextView)findViewById(R.id.txtHasilmtk);
    }
    private void tangkap() {
        nilai = getIntent().getIntExtra("nilai",0);
        Log.i("Tangkapan Sukses", String.valueOf(nilai));
    }
}