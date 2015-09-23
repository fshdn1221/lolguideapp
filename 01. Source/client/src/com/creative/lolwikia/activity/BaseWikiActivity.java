package com.creative.lolwikia.activity;

import com.creative.lolwikia.config.AppConfig;
import android.app.Activity;

/**
 * Basic activity class of this application
 * @author FSHDN
 * @since Sep 23, 2015
 */
public class BaseWikiActivity extends Activity{

    /**
     * Get application configuration instance. Convenience to {@link AppConfig#getInstance(android.content.Context)}
     * @return instance of {@link AppConfig}
     */
    protected AppConfig getConfiguration() {
        return AppConfig.getInstance(this);
    }
}
