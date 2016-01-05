package com.wopata.analyticswrapper.atinternet;

import android.content.Context;

import com.atinternet.tracker.Tracker;
import com.wopata.analyticswrapper.library.AbstractAnalytics;

import java.util.HashMap;

/**
 * Created by ardouin on 04/01/16.
 */
public class ATInternetAnalytics extends AbstractAnalytics {

    private Tracker mTracker;

    public static ATInternetAnalytics buildDefaultInstance(Context context, final int siteId) {
        HashMap config = new HashMap<String, Object>(){{
            put("site", siteId);
        }};
       return  buildWithConfig(context,config);
    }

    private static ATInternetAnalytics buildWithConfig(Context context, HashMap config) {
        return new ATInternetAnalytics(context,config);
    }

    private ATInternetAnalytics(Context context, final HashMap<String,Object> config) {
        mTracker = new Tracker(context);
        mTracker.setConfig(config,false, null);
    }


    @Override
    public void trackScreen(String screenName) {
        mTracker.Screens().add(screenName).sendView();
    }

    @Override
    public void trackClickEvent(String eventName) {
        mTracker.Gestures().add(eventName).sendTouch();
    }

}

