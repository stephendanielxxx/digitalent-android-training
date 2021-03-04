package com.example.digitalenttraining.maps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.digitalenttraining.R;
import com.example.digitalenttraining.model.OfficeModel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoAdapter implements GoogleMap.InfoWindowAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public CustomInfoAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View view = layoutInflater.inflate(R.layout.maps_info, null);

        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_address = view.findViewById(R.id.tv_address);
        TextView tv_employee = view.findViewById(R.id.tv_employee);

        OfficeModel officeModel = (OfficeModel) marker.getTag();

        tv_name.setText(officeModel.getName());
        tv_address.setText(officeModel.getAddress());
        tv_employee.setText("Employee : "+officeModel.getEmployee());

        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
