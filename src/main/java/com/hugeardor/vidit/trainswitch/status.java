package com.hugeardor.vidit.trainswitch;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vidit on 14/10/17.
 */

public class status  extends AppCompatActivity{

    TextView get_delay ;
    Button switch_pos , switch_neg ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.status);

        get_delay = (TextView)findViewById(R.id.get_t_s) ;

        get_delay.setTextColor(Color.RED);

        switch_pos = (Button)findViewById(R.id.switch_btn_pos);
        switch_neg = (Button)findViewById(R.id.switch_btn_neg);




    }

    public  void dont_switch(View view){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Press Ok to Continue Journey !").setTitle("Sure ?") ;

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                //open the settings menu

finish();

            }
        });



        AlertDialog dialog = builder.create() ;
        dialog.show();

    }

    public void switch_fn(View view){

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Train Delayed !").setTitle("Want to switch another train !") ;

        builder.setPositiveButton("Switch", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                //open the settings menu

               startActivity(new Intent(status.this , final_class.class));

            }
        });
        builder.setNegativeButton("Don't ! ", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                //open the settings menu



            }
        });




        AlertDialog dialog = builder.create() ;
        dialog.show();



    }
}
