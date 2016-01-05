package com.wopata.analyticswrapper.library;

import android.content.Context;

/**
 * Created by ardouin on 04/01/16.
 */
public abstract class AbstractAnalytics {

    public abstract void trackScreen(String screenName);

    public abstract void trackClickEvent(String eventName);

}
