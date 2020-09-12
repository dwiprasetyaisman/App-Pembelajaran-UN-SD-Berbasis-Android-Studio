package com.example.unmis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HasilbhsActivity extends AppCompatActivity {
    private LinearLayout mainn;
    Integer nilai, totalNilai;
    TextView txtHasilbhs;
    Button btnMainmenu, btnPenjbhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasilbhs);
        mainn = findViewById(R.id.mainmenu);
        btnPenjbhs = findViewById(R.id.btnPenjbhs);
        tangkap();
        kenalan();totalNilai = 100 * nilai / 30;
        txtHasilbhs.setText("Jawaban Benar Anda adalah " + nilai + "/30" + "\nNilai Anda adalah " + totalNilai);
        btnMainmenu = (Button)findViewById(R.id.btnMainmenu);

        btnMainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HasilbhsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnPenjbhs = (Button)findViewById(R.id.btnPenjbhs);

        btnPenjbhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HasilbhsActivity.this,PenjbhsActivity.class);
                startActivity(intent);
            }
        });
    }


    private void kenalan() { txtHasilbhs = (TextView)findViewById(R.id.txtHasilbhs);
    }
    private void tangkap() {
        nilai = getIntent().getIntExtra("nilai",0);
        Log.i("Tangkapan Sukses", String.valueOf(nilai));
    }
}
