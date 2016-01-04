package com.wopata.analyticswrapper.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ardouin on 04/01/16.
 */
public class AnalyticsManager extends AbstractAnalytics{

    private List<AbstractAnalytics> abstractAnalyticsInstances;

    public static AnalyticsManager instance;

    public AnalyticsManager(){
        abstractAnalyticsInstances = new ArrayList<>();
    }

    public void addAnalytics(AbstractAnalytics analytics){
        abstractAnalyticsInstances.add(analytics);
    }

    @Override
    public void tagScreen(String screenName) {
        for (AbstractAnalytics analytics : abstractAnalyticsInstances) {
            analytics.tagScreen(screenName);
        }
    }

    @Override
    public void tagClick(String clickName) {
        for (AbstractAnalytics analytics : abstractAnalyticsInstances) {
            analytics.tagClick(clickName);
        }
    }

    @Override
    public void tagPopup(String popupName) {
        for (AbstractAnalytics analytics : abstractAnalyticsInstances) {
            analytics.tagPopup(popupName);
        }

    }
}
