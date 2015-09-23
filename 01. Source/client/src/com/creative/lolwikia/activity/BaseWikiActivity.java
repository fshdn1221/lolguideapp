package com.creative.lolwikia.activity;

import com.creative.lolwikia.config.AppConfig;
import android.app.Activity;

public class BaseWikiActivity extends Activity{

    protected AppConfig getConfiguration() {
        return AppConfig.getInstance(this);
    }
}
