package com.example.gads_2020.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitService {
    private final static String SEND_URL = "https://docs.google.com/forms/d/e/";
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(SEND_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public <P> P buildServices(Class<P> endpoint) {
        return retrofit.create(endpoint);
    }
}
