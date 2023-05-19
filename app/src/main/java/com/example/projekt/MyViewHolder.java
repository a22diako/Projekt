package com.example.projekt;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView id;
    public TextView name;
    public TextView location;
    public TextView company;
    public TextView size;
    public TextView cost;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.id);
        name = itemView.findViewById(R.id.name);
        location = itemView.findViewById(R.id.location);
        company = itemView.findViewById(R.id.company);
        size = itemView.findViewById(R.id.size);
        cost = itemView.findViewById(R.id.cost);
    }
}
