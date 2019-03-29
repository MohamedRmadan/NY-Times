package com.example.nytimes.interfaces;

import com.example.nytimes.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    @GET("7.json")
    Call<ApiResponse> getArticles(@Query("api-key" ) String API_KEY);

}
