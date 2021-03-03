package com.example.digitalenttraining;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalCountryAdapter extends RecyclerView.Adapter<HorizontalCountryAdapter.ViewHolder>{

    private String[] countries;
    private CountryCallback countryCallback;

    // + interface
    public HorizontalCountryAdapter(String[] countries, CountryCallback countryCallback) {
        this.countries = countries;
        this.countryCallback = countryCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country_horizontal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String country = countries[position];
        holder.tv_country.setText(country);
        holder.cv_country.setOnClickListener(v->{
            countryCallback.onCountrySelected(country);
        });
    }

    @Override
    public int getItemCount() {
        return countries.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_country;
        public CardView cv_country;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_country = itemView.findViewById(R.id.tv_country);
            cv_country = itemView.findViewById(R.id.cv_country);
        }
    }

    public interface CountryCallback{
        void onCountrySelected(String country);
    }
}
