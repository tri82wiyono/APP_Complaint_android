package com.meridianid.farizdotid.mahasiswaapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by twonno on 1/28/2018.
 */

public class ResponseKantor {
    @SerializedName("semuakantor")
    private List<SemuakantorItem> semuakantor;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setSemuakantor(List<SemuakantorItem> semuakantor){
        this.semuakantor = semuakantor;
    }

    public List<SemuakantorItem> getSemuakantor(){
        return semuakantor;
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
                "ResponseKantor{" +
                        "semuakantor = '" + semuakantor + '\'' +
                        ",error = '" + error + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}
