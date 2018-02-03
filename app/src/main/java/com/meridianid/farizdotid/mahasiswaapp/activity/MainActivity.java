package com.meridianid.farizdotid.mahasiswaapp.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.meridianid.farizdotid.mahasiswaapp.R;
import com.meridianid.farizdotid.mahasiswaapp.util.SharedPrefManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    /*
    @BindView(R.id.tvResultNama)
    TextView tvResultNama;
    @BindView(R.id.btnLogout)
    Button btnLogout;
  //  @BindView(R.id.btnLihatDosen)
  //  Button btnLihatDosen;
  //  @BindView(R.id.btnLihatMatkul)
  //  Button btnLihatMatkul;
    @BindView(R.id.btnKantor)
    Button btnKantor;
    @BindView(R.id.btnATM)
    Button btnATM;
    @BindView(R.id.btnChangeProfil)
    ImageView btnChangeProfil;
*/

    @BindView(R.id.tvResultNama)
    TextView tvResultNama;
    @BindView(R.id.btnLogout)
    CardView btnLogout;
    @BindView(R.id.btnKantor)
    CardView btnKantor;
    @BindView(R.id.btnATM)
    CardView btnATM;
    @BindView(R.id.btnCallCenter)
    CardView btnCallCenter;
    @BindView(R.id.btnPengaduan)
    CardView btnPengaduan;


    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        sharedPrefManager = new SharedPrefManager(this);

        tvResultNama.setText(sharedPrefManager.getSPNama());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                startActivity(new Intent(MainActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });
    /*
        btnLihatDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DosenActivity.class));
            }
        });

        btnLihatMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MatkulActivity.class));
            }
        });
*/
        btnKantor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KantorActivity.class));
            }
        });

        btnATM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ATMActivity.class));
            }
        });

        btnPengaduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PengaduanActivity.class));
            }
        });

        btnCallCenter.setOnClickListener(new View.OnClickListener() {
            String phoneNumber = "14002";
            public void onClick(View v) {
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                //startActivity(new Intent(MainActivity.this, ATMActivity.class));
                startActivity(dialPhoneIntent);
            }
        });
    }
}