package com.example.gads_2020.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
        private static final String URL = "https://gadsapi.herokuapp.com/";
        private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create());


        private static Retrofit retrofit = builder.build();

        //helper class to assist in building services
        public static <S> S buildService(Class<S> serviceType) {
                return retrofit.create(serviceType);
        }

}
