package com.tronsis.cachedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tronsis.logger.Logger;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;
    private ACache aCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
//
//        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
//        ImageRequest imageRequest = new ImageRequest("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png",
//                new Response.Listener<Bitmap>() {
//                    @Override
//                    public void onResponse(Bitmap response) {
//                        iv.setImageBitmap(response);
//                    }
//                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                iv.setImageResource(R.mipmap.ic_launcher);
//                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
//            }
//        });
//        requestQueue.add(imageRequest);

        MyVolley myVolley = MyVolley.getInstance(MainActivity.this);
        myVolley.LoadIamge(iv,"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png",R.mipmap.ic_launcher);
    }


    public void logger(View v){
        String url = "";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Logger.json(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("key", "value");
                return map;
            }
        };

        requestQueue.add(stringRequest);
    }

}