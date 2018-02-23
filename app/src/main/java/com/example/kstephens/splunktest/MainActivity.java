package com.example.kstephens.splunktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.splunk.mint.Mint;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titleText = (TextView) findViewById(R.id.titleText);

        String splunkAPIKey= getResources().getString(R.string.SplunkKeyProd);

        //initiate Splunk Library
        Mint.initAndStartSession(this.getApplication(), splunkAPIKey); //android prod key

        titleText.setText("Splunk Mint SDK Key: " + splunkAPIKey);

    }

    public void doStuff(View view){
        Log.i("Crash","Application crashed");
        throw new RuntimeException("This is a crash");//Force a crash
    }

}
