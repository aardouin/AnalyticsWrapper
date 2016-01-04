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

    public ATInterentAnalytics(Context context, final String siteId) {
        HashMap config = new HashMap<String, Object>(){{
            put("site", siteId);
        }};
        mTracker.setConfig(config,false, null);
    }

    @Override
    public void tagScreen(String screenName) {
        mTracker.Screens().add(screenName).sendView();
    }

    @Override
    public void tagClick(String clickName) {
        mTracker.Gestures().add(clickName).sendTouch();
    }

    @Override
    public void tagPopup(String popupName) {
        mTracker.Context().setLevel2(1);
        mTracker.Screens().add(popupName).sendView();
        mTracker.Context().setLevel2(0);
    }
}
