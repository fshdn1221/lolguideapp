package com.creative.lolwikia.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Application configurations
 * 
 * @author FSHDN
 * @since Sep 22, 2015
 */
public class AppConfig {

    public static final String ATTR_SPLASH_TIMEOUT = "splash_min_dur";
    private static final String APP_SETTING_FILENAME = "config.properties";

    Properties mConfig;
    SharedPreferences mSettings;

    private static AppConfig mInstance;

    private AppConfig(Context context) {
        init(context);
    }

    private void init(Context context) {
        loadConfigurationFile(context);
        loadSettings(context);
    }

    private void loadConfigurationFile(Context context) {
        mConfig = new Properties();
        try {
            InputStream in = context.getAssets().open(APP_SETTING_FILENAME);
            mConfig.load(in);
        } catch (IOException e) {
            Log.e(getClass().getSimpleName(), "Cannot load configuration file. Cause: " + e.getMessage());
        }
    }

    private void loadSettings(Context context){
        mSettings = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    public static AppConfig getInstance(Context context) {
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
        if (config != null) {
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
        if (config != null) {
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
        if (config != null) {
            try {
                defaultValue = Float.parseFloat(config);
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        return defaultValue;
    }

    public SharedPreferences getSetting(){
        return mSettings;
    }
}
