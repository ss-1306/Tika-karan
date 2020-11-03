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
 * Created by Shreya on 10/14/2016.
 */

public class MyVaccinationScheduleActivity extends AppCompatActivity {
    Toolbar toolbar;
    BabyProfileAdapter adapter;
    String Json_String;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myvaccinationschedule);
        toolbar=(Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Tika Karan");


        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        adapter=new BabyProfileAdapter(MyVaccinationScheduleActivity.this,R.layout.babyprofilerowlayout);
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
                Intent i=new Intent(MyVaccinationScheduleActivity.this,VaccinationSchedule.class);
                i.putExtra("dob",send.toString());
                startActivity(i);

            }
        });

        // Defined Array values to show in ListView
       // String[] values = new String[] { "Rupali","Shreya","Goldy","Manju"};
        //String[] dates=new String[] {"27/04/2016","13/06/2016","14/10/2016","16/05/2017"};

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data



        // Assign adapter to ListView


      /*  int i=0;

        listView.setAdapter(adapter);
        for(String babyName: values){
           BabyProfileDataProvider babyProfileDataProvider=new BabyProfileDataProvider(babyName,dates[i]);
            adapter.add(babyProfileDataProvider);

            i++;
        }*/


    }

}
