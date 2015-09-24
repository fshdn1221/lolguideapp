package com.creative.lolwikia.activity.main;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import com.creative.lolwikia.R;
import com.creative.lolwikia.activity.BaseWikiActivity;
import com.creative.lolwikia.config.AppConfig;

/**
 * Splash screen
 * 
 * @since Sep 22, 2015
 * 
 * @author ThanhVV
 *
 */
public class SplashScreen extends BaseWikiActivity {

    public static final String TAG = "SplashScreen";
    public static final long DEF_SPLASH_TIME_OUT = 3000L;
    private boolean flagDataLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.screen_splash);
        long splashTimeOut = getConfiguration()
                .getLongProperty(AppConfig.ATTR_SPLASH_TIMEOUT, DEF_SPLASH_TIME_OUT);
        // Load data from server store into database
        new LoadData().execute();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startMainScreen();
            }
        }, splashTimeOut);
    }

    /**
     * Start main activity
     */
    private void startMainScreen() {
        if (!flagDataLoaded) {
            flagDataLoaded = true;
        } else {
            // Start main activity
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);

            // Close this activity
            finish();
        }
    }

    /**
     * AsyncTask handle load data from server
     * 
     * @author ThanhVV
     *
     */
    private class LoadData extends AsyncTask<Void, Void, Integer> {

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Void... params) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(4000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            return null;
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            startMainScreen();
        }
    }
}
