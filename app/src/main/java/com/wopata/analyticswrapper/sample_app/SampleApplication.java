package com.wopata.analyticswrapper.sample_app;

import android.app.Application;

import com.wopata.analyticswrapper.atinternet.ATInterentAnalytics;
import com.wopata.analyticswrapper.googleanalytics.GAAnalytics;
import com.wopata.analyticswrapper.library.AnalyticsManager;
import com.wopata.analyticswrapper.mixpanel.MixpanelAnalytics;


/**
 * Created by ardouin on 04/01/16.
 */
public class SampleApplication extends Application {

    private static final String ATINTERNET_ANALYTICS = "ATInternet";
    private static final String GAANALYTICS = "GoogleAnalytics";
    private static final String MIXPANEL = "Mixpanel";

    private static AnalyticsManager analyticsInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        analyticsInstance = new AnalyticsManager();
        analyticsInstance.addAnalytics(ATINTERNET_ANALYTICS,ATInterentAnalytics.buildDefaultInstance(getApplicationContext(),"ATSITE"));
        analyticsInstance.addAnalytics(GAANALYTICS,new GAAnalytics(getApplicationContext(),R.xml.global_tracker));
        analyticsInstance.addAnalytics(MIXPANEL,new MixpanelAnalytics(getApplicationContext(),"MIXPANEL_KEY"));
    }

    public static AnalyticsManager getAnalyticsInstance(){
        return analyticsInstance;
    }
}
