package com.wopata.analyticswrapper.atinternet;

import android.content.Context;

import com.atinternet.tracker.Tracker;
import com.wopata.analyticswrapper.library.AbstractAnalytics;

import java.util.HashMap;

/**
 * Created by ardouin on 04/01/16.
 */
public class ATInterentAnalytics extends AbstractAnalytics {

    private Tracker mTracker;

    public static ATInterentAnalytics buildDefaultInstance(Context context, final String siteId) {
        HashMap config = new HashMap<String, Object>(){{
            put("site", siteId);
        }};
       return  buildWithConfig(context,config);
    }

    private static ATInterentAnalytics buildWithConfig(Context context, HashMap config) {
        return new ATInterentAnalytics(context,config);
    }

    private ATInterentAnalytics(Context context, final HashMap<String,Object> config) {
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

    @Override
    public void tagPopup(String popupName) {
        mTracker.Context().setLevel2(1);
        mTracker.Screens().add(popupName).sendView();
        mTracker.Context().setLevel2(0);
    }
}

