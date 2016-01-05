package com.wopata.analyticswrapper.googleanalytics;

import android.content.Context;


import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.wopata.analyticswrapper.library.AbstractAnalytics;

/**
 * Created by ardouin on 05/01/16.
 */



public class GAAnalytics extends AbstractAnalytics {


    private final Tracker mTracker;

    public GAAnalytics(Context context, int trackerConfigResId) {
        GoogleAnalytics analytics = GoogleAnalytics.getInstance(context);
        mTracker = analytics.newTracker(trackerConfigResId);
    }

    @Override
    public void trackScreen(String screenName) {
        mTracker.setScreenName(screenName);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void trackClickEvent(String eventName) {
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory(eventName)
                .setAction("click")
                .build());
    }
}
