package com.uninove.minhalocalizacao;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    /*
    * Para termos acesso ao serviço de localização do aparelho, temos que declarar dois objetos.
    * Sendo eles da classe, LocationManager - Este server para gerenciar/usar o dispositivo do aparelho,
    * E da classe LocationListener - Este serve para "ouvir" o uso da localizaçao e defini alguns comportamentos para isso -.
    * */
    LocationManager locationManager; // Declaração
    LocationListener locationListener; // Declaração

    // Declaração do tipo GoogleMap para ter acessar as configuração do mapa.
    private GoogleMap mMap;

    // Este método verifica a requisição que foi feito pelo usuário
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        /*  Faz referência par a classe principal, pelo uso da palavra reservada 'super' e passa para essa classe
         */
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0, 0, locationListener);
                }
            }
        }
    }

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
    public void onMapReady(final GoogleMap googleMap) {
        // Inicializa o mMap com a referência do componente que possui o mapa (Fragment - no arquivo .layout)
        mMap = googleMap;

        /*
        * O objeto locationManager irá pegar por referência as informações do Serviço de localização contextual
        * */
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE); // Inicializo
        /*
        * o objeto locationListener irá ser responsável por ficar "ouvindo" a movimentação da localização
        * e através de alguns métodos ele faz o que lhe foi passado para realizar naquelas condições.
        * */
        locationListener = new LocationListener() { // Inicializo
            // Esse método é chamada toda vez que houver mudança na localização
            @Override
            public void onLocationChanged(Location location) {
                //Toast.makeText(MapsActivity.this, location.toString(), Toast.LENGTH_SHORT).show();
                mMap.clear();

                // Defini, através da localização recuperada, o novo ponto de localização e add marcador
                // e a camera
                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(userLocation).title("Você está aqui"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));

                /*
                * <<Documentação resumida>>
                * É um classe que manipula a geocodificação. Geoconding é o processo de transformar
                * um endereço de rua ou outra descrição em uma localização dentro das coordenadas.
                * A quantidade de informações que pode ser pegas pode ser um pouco esparsar, pois
                * ao mesmo tempo que você pode pegar um endereço completo, com todos os dados.
                * Você pode pegar um endereço que possui somente, por exemplo, nome da cidade e CEP.
                * */
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                /*
                * O try é usado justamente para podermos evitar que as informações incompletas
                * trave o nosso aplicativo.
                * O conceito de manipulação de exceções é muito usado e torna a aplicação robusta
                * */
                try {
                    // Cria uma lista com as informações que foram recuperadas
                    List<Address> addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    if (addressList != null && addressList.size() > 0) {
                        String address = "";

                        // Pega o logradouro
                        if (addressList.get(0).getThoroughfare() != null) {
                            address += addressList.get(0).getThoroughfare() + " ";
                        }

                        // Pega a localização
                        if (addressList.get(0).getLocality() != null) {
                            address += addressList.get(0).getLocality() + " ";
                        }

                        // Pega o código postal
                        if (addressList.get(0).getPostalCode() != null) {
                            address += addressList.get(0).getPostalCode() + " ";
                        }

                        // Pega a area (estado, distrito ou pais)
                        if (addressList.get(0).getAdminArea() != null) {
                            address += addressList.get(0).getAdminArea();
                        }

                        Toast.makeText(MapsActivity.this, address, Toast.LENGTH_SHORT).show();

                    }
                    Log.i("Informação do lugar", addressList.get(0).toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (Build.VERSION.SDK_INT < 23) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, locationListener);
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
            else
            {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
                Location lastKnowLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                mMap.clear();

                // Add a marker in Sydney and move the camera
                assert lastKnowLocation != null;
                LatLng userLocation = new LatLng(lastKnowLocation.getLatitude(), lastKnowLocation.getLongitude());
                mMap.addMarker(new MarkerOptions().position(userLocation).title("Você está aqui"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 10));
            }
        }
    }
}
