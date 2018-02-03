package com.meridianid.farizdotid.mahasiswaapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meridianid.farizdotid.mahasiswaapp.R;
import com.meridianid.farizdotid.mahasiswaapp.util.SharedPrefManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PengaduanActivity extends AppCompatActivity {

    @BindView(R.id.tvResultNama)
    TextView tvResultNama;
    @BindView(R.id.btnCamera)
    TextView btnCamera;

    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaduan);

        ButterKnife.bind(this);
        sharedPrefManager = new SharedPrefManager(this);
        tvResultNama.setText(sharedPrefManager.getSPNama());

    }
}
