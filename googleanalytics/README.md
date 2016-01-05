#Google Analytics 

In order to use google analytics you must use google play services plugin. 

Follow the first steps of the [guide](https://developers.google.com/analytics/devguides/collection/android/v4/).

Except you don't need to import : 

```groovy
compile 'com.google.android.gms:play-services-analytics:8.3.0'
```

##GAAnalytics instance creation

Use following : 

```java
new GAAnalytics(context,R.xml.global_tracker)
```