package com.meridianid.farizdotid.mahasiswaapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by twonno on 1/29/2018.
 */

public class SemuaatmItem {
    @SerializedName("lokasiatm")
    private String lokasiatm;

    @SerializedName("alamat")
    private String alamat;

    public void setLokasiatm(String lokasiatm){
        this.lokasiatm = lokasiatm;
    }

    public String getLokasiatm(){
        return lokasiatm;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getAlamat(){
        return alamat;
    }


    @Override
    public String toString(){
        return
                "SemuaatmItem{" +
                        ",Lokasiatm = '" + lokasiatm + '\'' +
                        ",alamat = '" + alamat + '\'' +
                        "}";
    }
}
