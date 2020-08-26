package com.prography.playeasy.lib;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientFactory {
    private static Retrofit service = null;
    private static final String BASE_URL = "http://api.theplayeasy.com";

    private RetrofitClientFactory() {
    }

    //RestClient에서 기본 URL설정, okhhttp 및 데이터를 파싱하는 GsonCOnverter를 지정한다
    public static <T> T getClient(Class<T> apiInterfaceClass) {
        if (service == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            service = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(
                            new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.SSS").create()
                    ))
                    .client(client)
                    .build();
        }

        return apiInterfaceClass.cast(service.create(apiInterfaceClass));
    }
}
