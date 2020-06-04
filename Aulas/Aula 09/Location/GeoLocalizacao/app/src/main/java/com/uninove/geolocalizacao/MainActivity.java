package com.uninove.geolocalizacao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    /*
     * Para termos acesso ao serviço de localização do aparelho, temos que declarar dois objetos.
     * Sendo eles da classe, LocationManager - Este server para gerenciar/usar o dispositivo do aparelho,
     * E da classe LocationListener - Este serve para "ouvir" o uso da localizaçao e defini alguns comportamentos para isso -.
     * */
    LocationManager locationManager;
    LocationListener locationListener;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0, 0, locationListener);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * O objeto locationManager irá pegar por referência as informações do Serviço de localização contextual
         * */
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        /*
         * o objeto locationListener irá ser responsável por ficar "ouvindo" a movimentação da localização
         * e através de alguns métodos ele faz o que lhe foi passado para realizar naquelas condições.
         * */
        locationListener = new LocationListener() {
            // Esse método é chamada toda vez que houver mudança na localização
            @Override
            public void onLocationChanged(Location location) {

                Log.i("Localização", location.toString());
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
        // ContextCompat server para verificar se ainda temos permissõa
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            // Atualiza as coordenadas
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0, 0, locationListener);
        }
    }
}
