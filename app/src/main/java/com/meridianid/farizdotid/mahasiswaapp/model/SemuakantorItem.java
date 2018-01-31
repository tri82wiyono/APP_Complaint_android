package com.meridianid.farizdotid.mahasiswaapp.model;

import com.google.gson.annotations.SerializedName;

import static android.R.attr.id;

/**
 * Created by twonno on 1/28/2018.
 */

public class SemuakantorItem {

    @SerializedName("namaKantor")
    private String namaKantor;

    @SerializedName("alamatKantor")
    private String alamatKantor;

    public void setNamaKantor(String namaKantor){
        this.namaKantor = namaKantor;
    }

    public String getNamaKantor(){
        return namaKantor;
    }

    public void setAlamatKantor(String alamatKantor){
        this.alamatKantor = alamatKantor;
    }

    public String getAlamatKantor(){
        return alamatKantor;
    }


    @Override
    public String toString(){
        return
                "SemuakantorItem{" +
                        ",namaKantor = '" + namaKantor + '\'' +
                        ",alamatKantor = '" + alamatKantor + '\'' +
                        "}";
    }
}
