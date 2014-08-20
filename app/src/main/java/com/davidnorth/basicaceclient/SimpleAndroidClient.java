package com.davidnorth.basicaceclient;

import android.net.http.AndroidHttpClient;
import android.util.Log;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Dave on 20/08/2014.
 */
public class SimpleAndroidClient {

    //This is the address that can be used to access the emulator on a local host
    private String localAddress = "http://10.0.2.2:4567";
    private String responseCode = "currently unset";
    private String responseString = "currently unset";



    public void launch() {

        Log.i("Launch:", "is running");
        AndroidHttpClient androidHttpClient = AndroidHttpClient.newInstance("defaultAgentName");

        //Recreates the curl, or browser call
        HttpGet httpGet = new HttpGet(localAddress + "/hello");

        //Now do the request
        try {
            //collect the response (This is the only line that does anything remotely)
            HttpResponse response = androidHttpClient.execute(httpGet);
            //do something with response


            // 1. see if it connected worked by printing this to the log
            responseCode = String.valueOf(response.getStatusLine().getStatusCode());
            Log.i("Status Line:", String.valueOf(response.getStatusLine()));

            // 2. use the response body to pull something out
            responseString = EntityUtils.toString(response.getEntity());
            Log.i("Get Entity:", String.valueOf(response.getEntity()));

        } catch (IOException e) {
            e.printStackTrace();
            responseCode = "didn't retrieve. Check Logcat stacktrace";
            responseString = "didn't retrieve. Check Logcat stacktrace";
        } finally {
            androidHttpClient.close();
        }
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseString() {
        return responseString;
    }
}
