package com.example.mevscovid.ui;

import android.util.Log;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceholderApis {


    @POST("userinfo.php")

    Call<Post> insertUser(@Body RequestBody body);
    //   @Field("user") String user,
    //   @Field("email") String email,
    //   @Field("mobile") String mobile,
    //   @Field("comments") String comments);
    }
