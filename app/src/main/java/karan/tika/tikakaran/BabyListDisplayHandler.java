package karan.tika.tikakaran;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class BabyListDisplayHandler extends AsyncTask<String,String,String> {
    Context context;
    AlertDialog alertDialog;
    String json_string;
    String id;
    BabyListDisplayHandler(Context ctx) {

        context=ctx;

    }



    protected String doInBackground(String... params) {
        String type = params[0];
         id=params[1];

        String babylist_url = "http://192.168.1.3:80/babydisplay.php";


        if (type.equals("BabyList")) {
            try {

                URL url = new URL(babylist_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();


                while ((json_string = bufferedReader.readLine()) != null) {
                    stringBuilder.append(json_string + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
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
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Fetching Data");
    }

    @Override
    protected void onPostExecute(String aVoid) {
        if(aVoid==null){
            Toast.makeText(context, "No Data Available", Toast.LENGTH_LONG).show();
        }
       if(id.equals("Vaccination")){
            Intent intent = new Intent(context,MyVaccinationScheduleActivity.class);
            intent.putExtra("JSON_Data",aVoid);
            context.startActivity(intent);
        }

        if(id.equals("BabyProfile")){
            Intent intent = new Intent(context,BabyProfileActivity.class);
            intent.putExtra("JSON_Data",aVoid);
            context.startActivity(intent);
        }

    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }



}
