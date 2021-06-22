package com.example.gom247.presensi5.Api;

/**
 * Created by Gom247 on 16/12/2017.
 */
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class UtilsApi {
    public static final String BASE_URL_API_Login = "http://139.59.124.245/rest/v2/public/api/mahasiswa/";
    public static BaseApiService getAPIServiceLogin(){
        return RetrofitClient.getClient(BASE_URL_API_Login).create(BaseApiService.class);
    }

    public static final String BASE_URL_API_Presence = "http://139.59.124.245/rest/v2/public/api/";
    public static BaseApiService getAPIService(){
        return RetrofitClients.getClient(BASE_URL_API_Presence).create(BaseApiService.class);
    }
}
