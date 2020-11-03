package karan.tika.tikakaran;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

/**
 * Created by Shreya on 10/14/2016.
 */

public class AddBabyActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText bname,dname,dcontact,dob;
     String json_string;
    String parse_json;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_baby_builder);
        toolbar=(Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Tika Karan");
         bname = (EditText) findViewById(R.id.tret_name);
         dname = (EditText) findViewById(R.id.Doctor_name);
         dcontact = (EditText) findViewById(R.id.Doctor_number);
        dob = (EditText) findViewById(R.id.dob);



    }

    public void proceed(View v){
                String bname1=bname.getText().toString();
                String dname1=dname.getText().toString();
                String dcontact1=dcontact.getText().toString();
                String dob1=dob.getText().toString();
                Intent it = new Intent(AddBabyActivity.this,HomeActivity.class);
                startActivity(it);
        String type="addbaby";
        AddbabyHandler addbabyHandler=new AddbabyHandler();
        addbabyHandler.execute(type,bname1,dname1,dcontact1,dob1);

    }
}

class AddbabyHandler extends AsyncTask<String,String,String> {


    AlertDialog alertDialog;


    @Override
    protected String doInBackground(String... params) {
        String type=params[0];
        String register_url="http://192.168.1.3:80/addbaby.php";

        if(type.equals("addbaby")){
            try {
                String bname =params[1];
                String dname =params[2];
                String dcontact =params[3];
                String dob =params[4];
                String gender="female";

                URL url=new URL(register_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"utf-8"));
                String post_data= URLEncoder.encode("bname","UTF-8")+"="+URLEncoder.encode(bname,"UTF-8")+"&"+URLEncoder.encode("dname","UTF-8")+"="+URLEncoder.encode(dname,"UTF-8")
                        +"&"+URLEncoder.encode("dcontact","UTF-8")+"="+URLEncoder.encode(dcontact,"UTF-8")+"&"+URLEncoder.encode("dob","UTF-8")+"="+URLEncoder.encode(dob,"UTF-8")
                        +"&"+URLEncoder.encode("gender","UTF-8")+"="+URLEncoder.encode(gender,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line=bufferedReader.readLine())!=null){
                    result +=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
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
        super.onPreExecute();
    }
    @Override
    protected void onPostExecute(String result) {

     super.onPostExecute(result);
    }


    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}




