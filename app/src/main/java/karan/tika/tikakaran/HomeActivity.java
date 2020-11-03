package karan.tika.tikakaran;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * Created by iit on 09-10-2016.
 */

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;


    CardView mBabyProfile, mMyVaccinationSchedule, mAddBaby, mSearchClinic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardviewhome);
        toolbar=(Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Tika Karan");


        mAddBaby = (CardView) findViewById(R.id.add_baby_builder);
        mMyVaccinationSchedule = (CardView) findViewById(R.id.myvaccination);
        mBabyProfile = (CardView) findViewById(R.id.baby_profile);
        mSearchClinic = (CardView) findViewById(R.id.search_clinic);


        mAddBaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this,AddBabyActivity.class);
                startActivity(intent);

            }
        });

        mMyVaccinationSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type="BabyList";
                BabyListDisplayHandler babyListDisplayHandler=new BabyListDisplayHandler(HomeActivity.this);
                String id="Vaccination";
                babyListDisplayHandler.execute(type,id);
                //String babyList=babyListDisplayHandler.getBabylist();



            }
        });

        mBabyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type="BabyList";
                BabyListDisplayHandler babyListDisplayHandler=new BabyListDisplayHandler(HomeActivity.this);
                String id="BabyProfile";
                babyListDisplayHandler.execute(type,id);

            }
        });

        mSearchClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this,ClinicNearYouActivity.class);
                startActivity(intent);

            }
        });

    }


}









