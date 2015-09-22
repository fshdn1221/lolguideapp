package com.creative.lolwikia.activity.main;

import com.creative.lolwikia.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

    private static final long SPLASH_TIME_OUT = 3000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.screen_splash);

        new Handler().postDelayed(new Runnable() {
            
            @Override
            public void run() {
                // Start main activity
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                
                // Close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
