package com.uridecy.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.messaging.FirebaseMessaging;
import com.uridecy.demo.MySingleton;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainState extends AppCompatActivity
        implements DriverFiltersDialogFragment.ItemClickListener {


    final private String FCM_API = "https://fcm.googleapis.com/fcm/send";
    final private String serverKey = "key=" + "AAAAKIzz5PI:APA91bGJq7PyiIL4DKY0mPhK13EdHT1_5S9kg0r9t1O9wiPNDonqPULFL_91utB6P3E-CSorr1gDb_g0-UxXoKZtmG9MQqZjT9uF99tKItkogU12Cq4_HsS7b3kW_9OFuU1nHJLNaeDu";
    final private String contentType = "application/json";
    final String TAG = "NOTIFICATION TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_state);

        FirebaseMessaging.getInstance().subscribeToTopic("URIDECY");
    }

    public void showBottomSheet(View view) {
        DriverFiltersDialogFragment addPhotoBottomDialogFragment =
                DriverFiltersDialogFragment.newInstance();
        addPhotoBottomDialogFragment.show(getSupportFragmentManager(),
                DriverFiltersDialogFragment.TAG);
    }

    @Override
    public void onItemClick(String item) {

    }

   public void logout (View view){
       Intent intent = new Intent(this,LaunchScreen.class);
       startActivity(intent);
   }

    public void viewReceivedRideRequests (View view){
        Intent intent = new Intent(this,Request.class);
        startActivity(intent);
    }

    public void viewSettings(View view){
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }

    private void sendNotification(JSONObject notification) {
        JsonObjectRequest jsonObjReq= new JsonObjectRequest(FCM_API, notification,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "onResponse: " + response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "onErrorResponse: Didn't work");
                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Authorization", serverKey);
                params.put("Content-Type", contentType);
                return params;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjReq);
    }

    public void sendRequest(View view){
        String NOTIFICATION_TITLE;
        String NOTIFICATION_MESSAGE;
        String TOPIC;

        TOPIC = "/topics/URIDECY"; //topic must match with what the receiver subscribed to
        NOTIFICATION_TITLE = "URideCY";
        NOTIFICATION_MESSAGE = "You have a new ride request!";

        JSONObject notification = new JSONObject();
        JSONObject notifcationBody = new JSONObject();
        try {
            notifcationBody.put("title", NOTIFICATION_TITLE);
            notifcationBody.put("message", NOTIFICATION_MESSAGE);

            notification.put("to", TOPIC);
            notification.put("data", notifcationBody);
        } catch (JSONException e) {
            Log.e(TAG, "onCreate: " + e.getMessage() );
        }
        sendNotification(notification);
    }

}