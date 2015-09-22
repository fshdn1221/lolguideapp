package com.creative.lolwikia.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import android.content.Context;

/**
 * Application configurations
 * @author FSHDN
 * @since Sep 22, 2015
 */
public class AppConfig {

    public static final String SPLASH_MIN_DURATION = "splash_min_dur";

    Properties mConfig;

    private static AppConfig mInstance;

    private AppConfig(Context context) {
        try {
            InputStream configFile = context.getResources().getAssets()
                    .open("config.properties");
            mConfig = new Properties();
            mConfig.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
            //TODO push log
        }
    }

    public static AppConfig getInstance(Context context){
        if (mInstance == null) {
            mInstance = new AppConfig(context);
        }
        return mInstance;
    }

    public String getProperty(String name, String defaultValue) {
        return mConfig.getProperty(name, defaultValue);
    }

}
