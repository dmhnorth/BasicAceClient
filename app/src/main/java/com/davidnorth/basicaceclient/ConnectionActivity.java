package com.davidnorth.basicaceclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ConnectionActivity extends Activity {

        SimpleAndroidClient simpleAndroidClient = new SimpleAndroidClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        //TODO not allowed to run network connections in the UI thread
        //http://www.androiddesignpatterns.com/2012/06/app-force-close-honeycomb-ics.html

//        simpleAndroidClient.launch();


    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.connection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void updateView(View view) {
        TextView portOkay = (TextView) findViewById(R.id.status_line);
        portOkay.setText(simpleAndroidClient.getResponseCode());

        TextView getServerString = (TextView) findViewById(R.id.get_server_string);
        getServerString.setText(simpleAndroidClient.getResponseString());

    }
}
