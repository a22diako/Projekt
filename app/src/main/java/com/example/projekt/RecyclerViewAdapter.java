package com.example.projekt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

    public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private List<HPpoints> hppoints;
        public RecyclerViewAdapter(List<HPpoints> hppoints) {

            this.hppoints = hppoints;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcontainer, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.id.setText(hppoints.get(position).getID());
            holder.name.setText(hppoints.get(position).getName());
            holder.location.setText(hppoints.get(position).getLocation());
            holder.company.setText(hppoints.get(position).getCompany());
            holder.size.setText(String.valueOf(hppoints.get(position).getSize()));
        }

        @Override
        public int getItemCount() {
            return hppoints.size();
        }
    }
