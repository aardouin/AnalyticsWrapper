package com.wopata.analyticswrapper.sample_app;

import android.app.Application;

import com.wopata.analyticswrapper.atinternet.ATInterentAnalytics;
import com.wopata.analyticswrapper.library.AnalyticsManager;


/**
 * Created by ardouin on 04/01/16.
 */
public class SampleApplication extends Application {

    private static AnalyticsManager analyticsInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        analyticsInstance = new AnalyticsManager();
        analyticsInstance.addAnalytics(ATInterentAnalytics.buildDefaultInstance(getApplicationContext(),"ATSITE"));
    }

    public static AnalyticsManager getAnalyticsInstance(){
        return analyticsInstance;
    }
}
