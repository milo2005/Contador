package com.example.estacionvl_tc_014.contador.threads;

import android.os.AsyncTask;

/**
 * Created by EstacionVL-TC-014 on 6/02/16.
 */
public class TimeAsyncTask extends AsyncTask<Integer,Integer,Integer> {

    public interface TimeI{
        void setTime(int seconds);
    }

    boolean running;
    boolean paused;

    TimeI timeI;

    public TimeAsyncTask(TimeI timeI) {
        this.timeI = timeI;
    }

    @Override
    protected Integer doInBackground(Integer... params) {
        running = true;
        paused = false;

        int seconds = 0;
        while (running){
            try {
                Thread.sleep(1000);
                if(!paused) {
                    seconds++;
                    publishProgress(seconds);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void stopTime(){
        running = false;
    }

    public void setPaused(boolean paused){
        this.paused = paused;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        timeI.setTime(values[0]);
    }
}
