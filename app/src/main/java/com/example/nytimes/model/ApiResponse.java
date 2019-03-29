package com.example.nytimes.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("status")
    private String status;
    @SerializedName("results")
    private List<NyArticle> results;

    public ApiResponse(String status, List<NyArticle> results) {
        this.status = status;
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<NyArticle> getResults() {
        return results;
    }

    public void setResults(List<NyArticle> results) {
        this.results = results;
    }
}
