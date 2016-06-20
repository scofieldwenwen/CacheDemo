package com.tronsis.cachedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

/**
 * @author scofield@tronsis.com
 * @date 2016/6/20 16:08
 */
public class MyVolley {

    private static MyVolley myVolley = null;
    private static RequestQueue requestQueue;

    public static MyVolley getInstance(Context context) {
        if (myVolley == null) {
            myVolley = new MyVolley();
            requestQueue = Volley.newRequestQueue(context);
        }
        return myVolley;
    }

    public static void LoadIamge(final ImageView imageView, String url, final int fialIamge) {

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, 0, 0,
                ImageView.ScaleType.CENTER, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageView.setImageResource(fialIamge);
            }
        });
        requestQueue.add(imageRequest);
    }
}
