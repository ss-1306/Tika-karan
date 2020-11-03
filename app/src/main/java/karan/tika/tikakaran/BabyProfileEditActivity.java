package karan.tika.tikakaran;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class BabyProfileEditActivity extends AppCompatActivity {
    Toolbar toolbar;
    String tDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.babyprofileedit);
        toolbar=(Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Tika Karan");
        String data=getIntent().getExtras().getString("dob");
        String token[]=data.split("\\s+");
        tDate=token[1];
        String bname=token[0];

    }

}
