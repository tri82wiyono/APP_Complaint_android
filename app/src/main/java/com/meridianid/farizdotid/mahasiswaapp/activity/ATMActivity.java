package com.meridianid.farizdotid.mahasiswaapp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.meridianid.farizdotid.mahasiswaapp.R;
import com.meridianid.farizdotid.mahasiswaapp.adapter.AtmAdapter;
import com.meridianid.farizdotid.mahasiswaapp.model.ResponseAtm;
import com.meridianid.farizdotid.mahasiswaapp.model.SemuaatmItem;
import com.meridianid.farizdotid.mahasiswaapp.util.api.BaseApiService;
import com.meridianid.farizdotid.mahasiswaapp.util.api.UtilsApi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ATMActivity extends AppCompatActivity {
    @BindView(R.id.rvLokasiatm)
    RecyclerView rvLokasiatm;
    ProgressDialog loading;

    Context mContext;
    List<SemuaatmItem> semuaatmItemList = new ArrayList<>();
    AtmAdapter atmAdapter;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm);

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();

        atmAdapter = new AtmAdapter(this, semuaatmItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvLokasiatm.setLayoutManager(mLayoutManager);
        rvLokasiatm.setItemAnimator(new DefaultItemAnimator());

        getResultListAtm();
    }

    private void getResultListAtm(){
        loading = ProgressDialog.show(this, null, "Harap Tunggu...", true, false);

        mApiService.getSemuaAtm().enqueue(new Callback<ResponseAtm>() {
            @Override
            public void onResponse(Call<ResponseAtm> call, Response<ResponseAtm> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    final List<SemuaatmItem> semuaatmItems = response.body().getSemuaatm();

                    rvLokasiatm.setAdapter(new AtmAdapter(mContext, semuaatmItems));
                    atmAdapter.notifyDataSetChanged();
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data daftar ATM", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAtm> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
