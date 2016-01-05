package com.wopata.analyticswrapper.sample_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button testButton = (Button)findViewById(R.id.testClick);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SampleApplication.getAnalyticsInstance().trackClickEvent("text click event");
            }
        });
   }

    @Override
    protected void onResume() {
        super.onResume();
        SampleApplication.getAnalyticsInstance().trackScreen("MainActivityScreen");
    }
}
