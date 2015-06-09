package shravs.com.blooddonorfinder;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class RestFulServices extends Service {
    private static final String TAG = "RestFulServices";
    private final IBinder myBinder = new MyLocalBinder();

    public RestFulServices() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myBinder;
    }

    public String register(String message) {
        Log.d(TAG, "register(), and message is = " + message);
        final StringBuilder jsonBuilder = new StringBuilder();
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(new URL("http://10.0.2.2:8080/bdf/webresources/bloodDonor/userInsertion?uFullName=Kolli&uName=kolli&uPwd=123456").openStream()));
                    String line;
                    while ((line = mBufferedReader.readLine()) != null) {
                        jsonBuilder.append(line);
                    }
                } catch (IOException e) {
                    Log.d(TAG, e.getMessage());
                }

            }
        }).start();

        return jsonBuilder.toString();
    }



    public class MyLocalBinder extends Binder {
        RestFulServices getService() {
            return RestFulServices.this;
        }
    }

}
