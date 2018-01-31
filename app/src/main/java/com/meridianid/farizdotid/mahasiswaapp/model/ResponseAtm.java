package com.meridianid.farizdotid.mahasiswaapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by twonno on 1/29/2018.
 */

public class ResponseAtm {
    @SerializedName("semuaatm")
    private List<SemuaatmItem> semuaatm;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setSemuaatm(List<SemuaatmItem> semuaatm){
        this.semuaatm = semuaatm;
    }

    public List<SemuaatmItem> getSemuaatm(){
        return semuaatm;
    }

    public void setError(boolean error){
        this.error = error;
    }

    public boolean isError(){
        return error;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString(){
        return
                "ResponseAtm{" +
                        "semuaatm = '" + semuaatm + '\'' +
                        ",error = '" + error + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}
