package com.creative.lolwikia.activity.main;

import com.creative.lolwikia.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Splash screen
 * 
 * @since Sep 22, 2015
 * 
 * @author ThanhVV
 *
 */
public class SplashScreen extends Activity {

    private static final long TIME_SLEEP = 3000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.screen_splash);

        Thread timerThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(TIME_SLEEP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
