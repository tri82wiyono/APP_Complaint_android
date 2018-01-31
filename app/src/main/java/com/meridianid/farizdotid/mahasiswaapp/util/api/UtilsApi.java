package com.meridianid.farizdotid.mahasiswaapp.util.api;

/**
 * Created by fariz ramadhan.
 * website : www.farizdotid.com
 * github : https://github.com/farizdotid
 */
public class UtilsApi {

    // 10.0.2.2 ini adalah localhost.
    //public static final String BASE_URL_API = "http://10.0.2.2/mahasiswa/";
    //public static final String BASE_URL_API = "http://192.168.1.13/mahasiswa/";
    public static final String BASE_URL_API = "http://www.api.triwiyono.com/mahasiswa/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
