package com.example.digitalenttraining.maps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.digitalenttraining.R;
import com.example.digitalenttraining.model.OfficeModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<OfficeModel> officeModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        officeModels.add(new OfficeModel("Digitalent", "Tebet", 50, -6.2271832, 106.84833));
        officeModels.add(new OfficeModel("Telkom", "Bandung", 500, -6.2263433, 106.848161));
        officeModels.add(new OfficeModel("Mc Donald", "Kuningan", 10, -6.2270112, 106.8479585));
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for(OfficeModel officeModel : officeModels){
            LatLng latLng = new LatLng(officeModel.getLatitude(), officeModel.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(latLng);

            Marker marker = googleMap.addMarker(markerOptions);
            marker.setTag(officeModel);
        }

        CustomInfoAdapter customInfoAdapter = new CustomInfoAdapter(getApplicationContext());
        googleMap.setInfoWindowAdapter(customInfoAdapter);

        LatLng current = new LatLng(officeModels.get(0).getLatitude(), officeModels.get(0).getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(current, 16f));

    }
}