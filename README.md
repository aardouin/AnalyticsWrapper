# AnalyticsWrapper
A multi analytics service wrapper

##Setup

Add `core` dependency, current version is `0.1`: 

```groovy
repositories {
    maven { url "https://jitpack.io" }
}
compile 'com.github.aardouin.analytics-wrapper:core:$version'
```


##Quick start guide

####Init AnalyticsManager 
It is advised to use AnalyticsManager as a singleton inside your application : 

```java
private static AnalyticsManager analyticsInstance;
@Override
public void onCreate() {
    super.onCreate();
    analyticsInstance = new AnalyticsManager();
}

public static AnalyticsManager getAnalyticsInstance(){
    return analyticsInstance;
}
```


In order to add a new analytics provider, include it into gradle : 

```groovy
compile 'com.github.aardouin.analytics-wrapper:$provider:$version'
```

Add provider instance to using : 

```java
analyticsInstance.addAnalytics(AbstractAnalytics analytics)
```


##Provider available
[AT Internet](./atinternet/)
