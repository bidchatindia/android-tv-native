package com.bidchat.bidchatanroidtvapp.Framework;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.bidchat.bidchatanroidtvapp.BidchatRestInterface;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abhik on 05-10-2016.
 */
public class BidApplication extends Application {

    public Retrofit retrofit;
    public OkHttpClient okHttpClient;
    public BidchatRestInterface APIService;

    public void setAPIAdapter()
    {

        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(getBaseURL())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService = retrofit.create(BidchatRestInterface.class);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public BidchatRestInterface getAPIService()
    {
        return APIService;
    }

    public String getBaseURL()
    {
        return "https://videowest.bidchatserver.com/superadmin/tv/v1/";
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setAPIAdapter();
    }
}
