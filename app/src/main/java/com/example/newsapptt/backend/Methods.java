package com.example.newsapptt.backend;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {

    @GET("v2/top-headlines?country=us&category=business&apiKey=508dfd8113fb424f9f0e3fae4a2686eb")
    Call<Model> getAllReport();

}
