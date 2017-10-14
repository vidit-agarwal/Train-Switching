package com.hugeardor.vidit.trainswitch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.os.Handler ;
import android.graphics.Matrix;
import android.widget.ImageView;

/**
 * Created by vidit on 14/10/17.
 */

public class SplashActivity extends Activity {


    private static int SPLASH_TIME_OUT = 3000;
    ImageView imageView ;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.splash);
        imageView = (ImageView)findViewById(R.id.logo)  ;
        Matrix matrix = new Matrix();
        //imageView.setScaleType(ImageView.ScaleType.MATRIX);   //required
        //matrix.postRotate((float) -20, 100, 100);
        //imageView.setImageMatrix(matrix);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
