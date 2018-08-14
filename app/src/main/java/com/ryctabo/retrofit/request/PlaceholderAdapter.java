package com.ryctabo.retrofit.request;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0
 */
public class PlaceholderAdapter {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private static PlaceholderService SERVICE;

    public static PlaceholderService getApiService() {
        if (SERVICE == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            SERVICE = retrofit.create(PlaceholderService.class);
        }
        return SERVICE;
    }

}
