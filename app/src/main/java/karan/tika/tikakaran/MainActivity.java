package karan.tika.tikakaran;

import android.content.Intent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



    }

    public void onlogin(View v){

        Intent it = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(it);

    }


}
