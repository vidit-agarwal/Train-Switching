package com.hugeardor.vidit.trainswitch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by vidit on 14/10/17.
 */

public class final_class  extends AppCompatActivity{

    TextView tn , pnr , seat_no , pnr_d , date ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.final_switch);

        tn = (TextView)findViewById(R.id.tn) ;
        pnr = (TextView)findViewById(R.id.pnr) ;

        seat_no = (TextView)findViewById(R.id.seat_no) ;
        pnr_d = (TextView)findViewById(R.id.pnr_d) ;
        date = (TextView)findViewById(R.id.date) ;

        tn.setText("Delhi-Mumbai Express");
        pnr.setText("2147483647");

        seat_no.setText("COACH AC SEAT 14");

        date.setText("12/10/2017");
        pnr_d.setText("Agra");

    }
}
