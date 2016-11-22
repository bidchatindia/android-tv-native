package com.bidchat.bidchatanroidtvapp;

import com.bidchat.bidchatanroidtvapp.Model.Broadcast;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by abhik on 05-10-2016.
 */
public interface BidchatRestInterface {

    @Headers("Authorization:Basic YmlkY2hhdF9hZG1pbl9zdTp1ZiZLOVlWdSVFJEo5bnco")
    @GET("top")
    Call<List<Broadcast>> listBroadcast();
}
