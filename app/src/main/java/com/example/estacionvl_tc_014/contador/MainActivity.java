package com.example.estacionvl_tc_014.contador;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.estacionvl_tc_014.contador.threads.TimeAsyncTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TimeAsyncTask.TimeI {

    Button start, pause, stop;
    TextView seconds;

    TimeAsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.btn_start);
        pause = (Button) findViewById(R.id.btn_pause);
        stop = (Button) findViewById(R.id.btn_stop);

        seconds = (TextView) findViewById(R.id.seconds);

        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_start:
                startCont();
                break;
            case R.id.btn_pause:
                pauseCont();
                break;
            case R.id.btn_stop:
                stopCont();
                break;
        }
    }

    private void stopCont() {
        if(task != null)
            task.stopTime();
        task = null;
    }

    private void pauseCont() {
        if(task!=null)
            task.setPaused(true);

    }

    private void startCont() {
        if(task == null){
            task = new TimeAsyncTask(this);
            task.execute();
        }else{
            task.setPaused(false);
        }

    }

    @Override
    public void setTime(int s) {
        seconds.setText(""+s);
    }
}
