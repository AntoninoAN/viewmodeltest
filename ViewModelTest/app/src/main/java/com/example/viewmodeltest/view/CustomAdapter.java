package com.example.viewmodeltest.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewmodeltest.R;
import com.example.viewmodeltest.model.Result;


public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Result dataSet;

    public void setDataSet(Result dataSet){
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_name.setText(dataSet.contacts.get(position).name);
        holder.tv_email.setText(dataSet.contacts.get(position).email);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ?
                dataSet.contacts.size()
                :
                0;
    }
}
