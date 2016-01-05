#AT Internet Analytics 

Easy instance init with site id  : 

```java
ATInterentAnalytics.buildDefaultInstance(getApplicationContext(),"ATSITE_ID")
```

Custom params : 

```java
HashMap config = new HashMap<String, Object>(){{
            put("site", siteId);
            //add custom config 
        }};
ATInterentAnalytics.buildWithConfig(getApplicationContext(),config)
```