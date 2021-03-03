package com.example.digitalenttraining;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder>{

    private String[] countries;

    public CountryAdapter(String[] countries){
        this.countries = countries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String country = countries[position];
        holder.tv_country.setText(country);
    }

    @Override
    public int getItemCount() {
        return countries.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_country;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_country = itemView.findViewById(R.id.tv_country);
        }

    }
}
