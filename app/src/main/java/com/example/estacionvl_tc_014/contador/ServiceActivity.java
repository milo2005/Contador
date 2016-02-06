package com.example.estacionvl_tc_014.contador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.estacionvl_tc_014.contador.services.TimeService;


public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    Button accion1, accion2, accion3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        accion1 = (Button) findViewById(R.id.accion1);
        accion2 = (Button) findViewById(R.id.accion2);
        accion3 = (Button) findViewById(R.id.accion3);

        accion1.setOnClickListener(this);
        accion2.setOnClickListener(this);
        accion3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent  intent = new Intent(this, TimeService.class);
        switch (v.getId()){
            case R.id.accion1:
                intent.setAction(TimeService.ACTION_1);
                break;
            case R.id.accion2:
                intent.setAction(TimeService.ACTION_2);
                break;
            case R.id.accion3:
                intent.setAction(TimeService.ACTION_3);
                break;
        }
        startService(intent);
    }
}
