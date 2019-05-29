package com.example.viewmodeltest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.viewmodeltest.model.ApiInterface;
import com.example.viewmodeltest.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomViewModel extends ViewModel {
    private MutableLiveData<Result> dataSetContacts= new MutableLiveData<>();
//    private MutableLiveData<PlayerPojo> dataSetPlayerName= new MutableLiveData<>();

    public LiveData<Result> initRetrofit(){
        new Retrofit.Builder()
                .baseUrl("https://api.androidhive.info/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface.class)
                .getContacts()
                .enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        if(response.isSuccessful())
                            dataSetContacts.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {

                    }
                });
        return dataSetContacts;
    }

//    getPlayerDetails(name : String) : LiveData<PlayerPojo> {
//
//        return dataSetPlayerName.postValue(DatabaseHelper.getDAta(name););
//    }
//
//    insertBatting(playerTEam : STring){
//        db.insertBAttting(playerTEam);
//    }
}
