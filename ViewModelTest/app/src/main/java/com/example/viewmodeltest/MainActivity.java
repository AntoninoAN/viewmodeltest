package com.example.viewmodeltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.viewmodeltest.model.Result;
import com.example.viewmodeltest.view.CustomAdapter;
import com.example.viewmodeltest.viewmodel.CustomViewModel;

public class MainActivity extends AppCompatActivity {

    CustomViewModel customViewModel;
    CustomAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainACtivity", "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list_contacts);
        adapter = new CustomAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        customViewModel = ViewModelProviders.of(this)
                .get(CustomViewModel.class);

//        cusmtomViewmodel2 = ViewModelProviders.of(this)
//                .get(CustomViewModel2.class);

//        customViewModel.initRetrofit().observe(
//                this,
//                pojo -> {
//                    //adapter.setAdapter
//                }
//        );
        customViewModel.initRetrofit().observe(
                this,
                this::getResult
        );
    }

    public void getResult(Result pojo){
        //todo init the adapter with the values
        adapter.setDataSet(pojo);
    }
    public void setResult(){

    }
}
