package com.example.meumapa;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Adiciona um marcador na posiçao informada (Pontos cardiais)
        // Pontos cardiais da sé -23.5509935,-46.6350264
        LatLng pracaSe = new LatLng(-23.5509935, -46.6350264);

        // Altera o tipo de visualizaçao do mapa quando inicializa
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        //mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // mMap.setMapType(GoogleMap.MAP_TYPE_NONE);

        // Adicionando título e posição para o marcador
        mMap.addMarker(new MarkerOptions().position(pracaSe).title("Estou no centro de SP").
                icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        // Movendo o foco da tela para a posição informada
        float zoomLevel = 16.0f; // O nivel vai até 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pracaSe, zoomLevel));

        /*
        // Adiciona um marcador na posiçao informada (Pontos cardiais)
        // Pontos cardiais da sé -23.5509935,-46.6350264
        LatLng pracaSe = new LatLng(-23.5509935, -46.6350264);

        // Adicionando título e posição para o marcador
        mMap.addMarker(new MarkerOptions().position(pracaSe).title("Estou no centro de SP"));
        // Movendo o foco da tela para a posição informada
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pracaSe));
        */
    }
}
