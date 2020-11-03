package karan.tika.tikakaran;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shreya And Rupali on 10/14/2016.
 */

public class BabyProfileActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    BabyProfileEditAdapter adapter;
    String Json_String;
    JSONObject jsonObject;
    JSONArray jsonArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.babyprofile);
        toolbar=(Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Tika Karan");


        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        adapter=new BabyProfileEditAdapter(BabyProfileActivity.this,R.layout.babyprofilerowlayout);
        listView.setAdapter(adapter);


        Json_String=getIntent().getExtras().getString("JSON_Data");

        try{
            jsonObject =new JSONObject(Json_String);
            jsonArray=jsonObject.getJSONArray("server_response");
            int count=0;

            String bname,dob;

            while(count < jsonArray.length()){
                JSONObject jo=jsonArray.getJSONObject(count);
                dob=jo.getString("dob");
                bname=jo.getString("bname");
                BabyProfileDataProvider babyProfileDataProvider=new BabyProfileDataProvider(bname,dob);
                adapter.add(babyProfileDataProvider);
                count++;
            }


        }catch(JSONException j){
            j.printStackTrace();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BabyProfileDataProvider babyProfileDataProvider=(BabyProfileDataProvider) parent.getItemAtPosition(position);
                StringBuilder send=new StringBuilder(babyProfileDataProvider.getBabyName().toString()).append(" ").append(babyProfileDataProvider.getDates().toString());
                Intent i=new Intent(BabyProfileActivity.this,BabyProfileEditActivity.class);
                i.putExtra("dob",send.toString());
                startActivity(i);

            }
        });

    }






}

