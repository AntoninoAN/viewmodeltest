package com.example.viewmodeltest.model;

import androidx.lifecycle.LiveData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("contacts/")
    Call<Result> getContacts();

}
