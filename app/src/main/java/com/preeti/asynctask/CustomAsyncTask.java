package com.preeti.asynctask;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Game on 30-09-17.
 */

public abstract class CustomAsyncTask implements Runnable {


    Handler preExecuteHandler;
    Handler doInBackground;
    Handler postExecutionHandler;

    public CustomAsyncTask(){

        preExecuteHandler = new Handler(Looper.getMainLooper());
        postExecutionHandler = new Handler(Looper.getMainLooper());
        doInBackground = new Handler();
    }

    protected void onPreExecute(){


    }

    protected abstract void onBackground();

    protected void onPostExecute(){

    }

    @Override
    public void run() {
        onBackground();
    }

    public void execute(){
        preExecuteHandler.post(new Runnable() {
            @Override
            public void run() {
                onPreExecute();
            }
        });

        doInBackground.post(new Runnable() {
            @Override
            public void run() {
                onBackground();

            }
        });
    }
}
