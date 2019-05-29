package com.example.viewmodeltest.view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewmodeltest.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView tv_name, tv_email;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_email = itemView.findViewById(R.id.tv_email);
        tv_name = itemView.findViewById(R.id.tv_name);
    }
}
