package com.hugeardor.vidit.trainswitch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vidit on 14/10/17.
 */

public class train_select extends AppCompatActivity {

    ListView lv ;
    List<file> mfilelist;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.train_switch_layout);
        mfilelist = new ArrayList<>();

        lv = (ListView)findViewById(R.id.lv);

    }

    public void submit(View view){
        startActivity(new Intent(train_select.this , final_class.class));
    }
}
