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

    public static final String ATTR_SPLASH_TIMEOUT = "splash_min_dur";

    Properties mConfig;

    private static AppConfig mInstance;

    private AppConfig(Context context) {
        mConfig = new Properties();
        try {
            InputStream configFile = context.getResources().getAssets()
                    .open("config.properties");
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

    public String getStringValueProperty(String name, String defaultValue) {
        return mConfig.getProperty(name, defaultValue);
    }

    public long getLongProperty(String name, long defaultValue) {
        String config = mConfig.getProperty(name, null);
        if (config != null){
            try {
                defaultValue = Long.parseLong(config);
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        return defaultValue;
    }

    public int getIntProperty(String name, int defaultValue) {
        String config = mConfig.getProperty(name, null);
        if (config != null){
            try {
                defaultValue = Integer.parseInt(config);
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        return defaultValue;
    }

    public float getFloatProperty(String name, float defaultValue) {
        String config = mConfig.getProperty(name, null);
        if (config != null){
            try {
                defaultValue = Float.parseFloat(config);
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        return defaultValue;
    }
}
