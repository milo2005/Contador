package com.example.estacionvl_tc_014.contador.services;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;


public class TimeService extends IntentService {

    public static final String ACTION_1="com.example.accion1";
    public static final String ACTION_2="com.example.accion2";
    public static final String ACTION_3="com.example.accion3";

    public TimeService() {
        super("TimeService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent.getAction().equals(ACTION_1)){
            accionUno();
        }else if(intent.getAction().equals(ACTION_2)){
            accionDos();
        }else{
            accionTres();
        }
    }

    private void accionTres() {

        Notification notification = new NotificationCompat.Builder(this)
                .setContentText("Contando ....")
                .setContentTitle("Servicio Corriendo")
                .setSmallIcon(android.R.drawable.ic_media_play)
                .build();

        startForeground(101,notification);


        for(int i=0;i<12;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i("Servicio","Segundos:"+i);
        }

        stopForeground(true);
    }

    private void accionDos() {
        Log.i("Servicio","Entro en Accion 2");
    }

    private void accionUno() {
        Log.i("Servicio","Entro en Accion 1");
    }

}
