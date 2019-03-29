package com.example.nytimes.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.nytimes.model.NyArticle;
import com.example.nytimes.R;
import com.example.nytimes.network.RetrofitClientInstance;
import com.example.nytimes.adapters.ArticleAdapter;
import com.example.nytimes.interfaces.GetDataService;
import com.example.nytimes.model.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArticleAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ApiResponse> call = service.getArticles("k3EggNOALS4zvAmpeSA2A3wZ2AXKjiUX");
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t)
            { progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(ApiResponse apiResponse) {
        List<NyArticle> articlesList = apiResponse.getResults();
        recyclerView = findViewById(R.id.articlesRecycler);
        adapter = new ArticleAdapter(this,articlesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}

