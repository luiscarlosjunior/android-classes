package com.example.meumapa2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        // Faço a referência ao componente fragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        // Chamando a API
        mapFragment.getMapAsync(this);
    }

    /**
     * Traduzido do original
     * Manipula o mapa uma vez criado.
     * Quando o mapa está pronto é usado um gatilha para a chamada
     * Aqui é onde nos podemos adicionar marcadores ou linhas, adicionar 'listeners' or
     * mover a camera. Neste caso, nós apenas adicionamos um marcador perto de Sidnei, Australia
     * Se o serviço do Google Play não estiver instalado no dispositivo,
     * o usuário receberá uma mensagem para instalar dentro do 'SupportMapFragment'
     * Este método somente irá ser chamado uma vez para o usuário que tenha instalado o
     * 'Google Play Services' e irá retornar para o aplicativo.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng emAlgumLugar = new LatLng(-88.36542, -45.69854);
        mMap.addMarker(new MarkerOptions().position(emAlgumLugar).title("Estou aqui"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(emAlgumLugar));
    }
}
