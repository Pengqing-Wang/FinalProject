package com.example.finalproject;

        import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    private static RequestQueue requestQueue;
    private static final String TAG = "Final Project main";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cnyConvertion();
        eurConvertion();
        cadConvertion();
        jpyConvertion();
        rubConvertion();
        gbpConvertion();
    }
    private void cnyConvertion() {
        Button cnyButton = (Button) findViewById(R.id.CNY);
        cnyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, USD_to_CNY.class));
            }
        });
    }
    private void eurConvertion() {
        Button eurButton = (Button) findViewById(R.id.EUR);
        eurButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, USD_to_EUR.class));
            }
        });
    }
    private void cadConvertion() {
        Button eurButton = (Button) findViewById(R.id.CAD);
        eurButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, USD_to_CAD.class));
            }
        });
    }
    private void jpyConvertion() {
        Button eurButton = (Button) findViewById(R.id.JPY);
        eurButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, USD_to_JPY.class));
            }
        });
    }
    private void rubConvertion() {
        Button eurButton = (Button) findViewById(R.id.RUB);
        eurButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, USD_to_RUB.class));
            }
        });
    }
    private void gbpConvertion() {
        Button eurButton = (Button) findViewById(R.id.GBP);
        eurButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, USD_to_GBP.class));
            }
        });
    }
}
