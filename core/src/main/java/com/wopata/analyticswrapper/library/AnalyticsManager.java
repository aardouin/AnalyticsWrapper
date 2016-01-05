package com.wopata.analyticswrapper.library;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ardouin on 04/01/16.
 */
public class AnalyticsManager extends AbstractAnalytics{

    private static final String TAG = "AnalyticsManager";
    private HashMap<String,AbstractAnalytics> analyticsMap;

    public static AnalyticsManager instance;

    public AnalyticsManager(){
        analyticsMap = new HashMap<>();
    }

    public void addAnalytics(String name,AbstractAnalytics analytics){
        if( name == null){
            analytics.getClass().getSimpleName();
        }
        analyticsMap.put(name,analytics);
    }

    public AbstractAnalytics getAnalyticsInstance(String name){
        return analyticsMap.get(name);
    }

    @Override
    public void trackScreen(String screenName) {
        Log.d(TAG,"==== Tracking screen : "+ screenName +" =====");
        for (AbstractAnalytics analytics : analyticsMap.values()) {
            try{
                analytics.trackScreen(screenName);
                Log.d(TAG,analytics.getClass().getSimpleName()+ " screen successfully tracked");
            }catch (UnsupportedOperationException ex){
                Log.e(TAG,"trackScreen operation is not supported by : " + analytics.getClass().getSimpleName());
            }
        }
        Log.d(TAG,"==== Tracking screen END : "+ screenName +" =====");
    }

    @Override
    public void trackClickEvent(String eventName) {

        Log.d(TAG,"==== Tracking click event : "+ eventName +" =====");
        for (AbstractAnalytics analytics : analyticsMap.values()) {
            try{
                analytics.trackClickEvent(eventName);
                Log.d(TAG,analytics.getClass().getSimpleName()+ " click event successfully tracked");
            }catch (UnsupportedOperationException ex){
                Log.e(TAG,"trackClickEvent operation is not supported by : " + analytics.getClass().getSimpleName());
            }
        }
        Log.d(TAG,"==== Tracking click event END : "+ eventName +" =====");
    }

}
