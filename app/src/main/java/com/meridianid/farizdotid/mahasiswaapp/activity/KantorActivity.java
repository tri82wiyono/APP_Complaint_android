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
import com.meridianid.farizdotid.mahasiswaapp.adapter.DosenAdapter;
import com.meridianid.farizdotid.mahasiswaapp.adapter.KantorAdapter;
import com.meridianid.farizdotid.mahasiswaapp.model.ResponseDosen;
import com.meridianid.farizdotid.mahasiswaapp.model.ResponseKantor;
import com.meridianid.farizdotid.mahasiswaapp.model.SemuadosenItem;
import com.meridianid.farizdotid.mahasiswaapp.model.SemuakantorItem;
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

public class KantorActivity extends AppCompatActivity {
    @BindView(R.id.rvKantor)
    RecyclerView rvKantor;
    ProgressDialog loading;

    Context mContext;
    List<SemuakantorItem> semuakantorItemList = new ArrayList<>();
    KantorAdapter kantorAdapter;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kantor);

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();

        kantorAdapter = new KantorAdapter(this, semuakantorItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvKantor.setLayoutManager(mLayoutManager);
        rvKantor.setItemAnimator(new DefaultItemAnimator());

        getResultListKantor();
    }

    private void getResultListKantor(){
        loading = ProgressDialog.show(this, null, "Harap Tunggu...", true, false);

        mApiService.getSemuaKantor().enqueue(new Callback<ResponseKantor>() {
            @Override
            public void onResponse(Call<ResponseKantor> call, Response<ResponseKantor> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    final List<SemuakantorItem> semuakantorItems = response.body().getSemuakantor();

                    rvKantor.setAdapter(new KantorAdapter(mContext, semuakantorItems));
                    kantorAdapter.notifyDataSetChanged();
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseKantor> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
