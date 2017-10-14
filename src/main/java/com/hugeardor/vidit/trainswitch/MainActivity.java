package com.hugeardor.vidit.trainswitch;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {


    TextView get_ts, tn, pnr, source, pnr_d, date;
    // String address = "http://10.60.59.32/trainswitch/insert.php" ;
    String p_n_r;
    public String retunnumfromAsyncTask;
    InputStream is = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        get_ts = (TextView) findViewById(R.id.get_ts);
        get_ts.setText("Confirmed");

        tn = (TextView) findViewById(R.id.tn);
        tn.setText("Ludhiana-Bhopal Express");

        pnr = (TextView) findViewById(R.id.pnr);
        pnr.setText("2147483647");

        p_n_r = pnr.getText().toString();

        source = (TextView) findViewById(R.id.source);
        source.setText("Delhi");

        pnr_d = (TextView) findViewById(R.id.pnr_d);
        pnr_d.setText("Agra");

        date = (TextView) findViewById(R.id.date);
        date.setText("12/10/2017");

        // this will tell whether the train is delayed or not

        //  backgroundWorker.getStatus() ;


    }

    public void status(View view) {
        String type = "fetch";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, p_n_r);

        //  startActivity(new Intent(MainActivity.this , status.class));
    }


    public class BackgroundWorker extends AsyncTask<String, Void, String> {


        Context context;
        AlertDialog alertDialog;
        String p_n_r;

        BackgroundWorker(Context ctx) {
            context = ctx;
        }

        @Override


        protected String doInBackground(String... params) {

            String type = params[0];
            String pnr = params[1];
            p_n_r = pnr;
            String login_url = "http://10.60.59.32/trainswitch/insert.php";
            if (type.equals("fetch")) {
                try {

                    String key = "fetch_data";
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);

                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                    String post_data = URLEncoder.encode("pnr", "UTF-8") + "=" + URLEncoder.encode(p_n_r, "UTF-8");

                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();


                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String res = "";
                    StringBuilder result = new StringBuilder();
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result.replace(0,result.length(),line);
                    }
                    res = result.toString();

                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    try {
                        JSONArray ja = new JSONArray(res);
                        JSONObject jo = null;

                        jo = ja.getJSONObject(0);
                        res = jo.getString("result");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    return res;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return null;


        }

        @Override
        protected void onPreExecute() {
            // super.onPreExecute();

            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Delay Status");
        }

        @Override
        protected void onPostExecute(String result) {
      /*  MainActivity mainactivity = (MainActivity)context;
        mainactivity.retunnumfromAsyncTask = result;
        super.onPostExecute(result);
*/
            String del="a";
            result = result.replace(" ","") ;
            if (result.equals("1"))
                del = "Delayed";
            else
                del = " Not Delayed";
         Toast.makeText(MainActivity.this , del , Toast.LENGTH_SHORT).show();

            if (del.equals("Delayed") ) {

                startActivity(new Intent(MainActivity.this , status.class));
                //Toast.makeText(MainActivity.this , "hello" , Toast.LENGTH_SHORT).show();
            }


        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }


    }
}