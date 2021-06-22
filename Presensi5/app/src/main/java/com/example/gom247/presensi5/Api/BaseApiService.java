package com.example.gom247.presensi5.Api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Gom247 on 16/12/2017.
 */

public interface BaseApiService {

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody>loginRequest(@Field("nim") String nims, @Field("password") String passwords);

    @FormUrlEncoded
    @POST("presensi")
    Call<ResponseBody> simpanPresensi(@Field("nim") String nims);
}
