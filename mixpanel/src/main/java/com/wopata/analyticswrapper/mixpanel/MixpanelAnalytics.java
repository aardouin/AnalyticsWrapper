package com.wopata.analyticswrapper.mixpanel;

import android.content.Context;

import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.wopata.analyticswrapper.library.AbstractAnalytics;

/**
 * Created by ardouin on 05/01/16.
 */
public class MixpanelAnalytics extends AbstractAnalytics {

    private final MixpanelAPI mixpanelApi;

    public MixpanelAnalytics(Context context, String projectToken){
        mixpanelApi = MixpanelAPI.getInstance(context,projectToken);
    }

    @Override
    public void trackScreen(String screenName) {
        mixpanelApi.track(screenName);
    }

    @Override
    public void trackClickEvent(String eventName) {
        mixpanelApi.track(eventName);

    }
}
