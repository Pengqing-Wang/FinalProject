package com.example.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.HashMap;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class USD_to_CNY extends AppCompatActivity {

    private static RequestQueue requestQueue;
    private static final String TAG = "Final Project main";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestQueue = Volley.newRequestQueue(this);
        setContentView(R.layout.activity_usd_to__cny);
        Button convert = findViewById(R.id.convertButton);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText numEntered = (EditText) findViewById(R.id.cnyenter);
                Double amountEntered = Double.parseDouble(numEntered.getText().toString());
                startAPICall(amountEntered);
            }
        });
        goBack();
    }
    void startAPICall(final Double amountEntered) {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "http://www.apilayer.net/api/live?access_key=2c6c184d4aaaf3e76ea2e2ecbc62ad2d",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            System.out.println(response.toString());
                            processResponse(response, amountEntered);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.d(TAG, error.toString());
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void processResponse(final JSONObject response, final Double amountEntered) {
        try {
            Double exchangeRate = response.getJSONObject("quotes").getDouble("USDCNY");
            Double convertedAmount = amountEntered * exchangeRate;
            TextView cnyoutput = (TextView) findViewById(R.id.cnyoutput);
            cnyoutput.setText(convertedAmount.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void goBack() {
        Button back = (Button) findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
