package com.example.gads_2020.Service;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

//helper class to assist in building services
public class ServiceBuilder {
    public static <S> S service(Class<S> serviceClass, String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build().create(serviceClass);
    }
}
