package com.wopata.analyticswrapper.library;

import android.content.Context;

/**
 * Created by ardouin on 04/01/16.
 */
public abstract class AbstractAnalytics {

    public abstract void tagScreen(String screenName);

    public abstract void tagClick(String clickName);

    public abstract void tagPopup(String popupName);
}
