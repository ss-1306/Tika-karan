package karan.tika.tikakaran;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static karan.tika.tikakaran.R.id.button;

public class VaccinationSchedule extends AppCompatActivity {
Toolbar toolbar;
String tDate;
    TextView tv;
    ListView listView;
    String[] values = new String[] { "BCG","OPV0","Hepatitus B1","Oral Rotavirus 1 *#","DTwP1/DTaP1","OPV1*/ OPV1 + IPV1","Hib1",
                                    "HepB2","PCV1","Oral Rotavirus 2","DTwP2/DTaP2","OPV2* / OPV2 + IPV2","Hib2","PCV2",
                                    "DTwP3/DTaP3","OPV 3* / OPV3 + IPV3","Hib3","HepB3**","PCV3","Measles","Hepatitus A1","MMR1",
                                    "Varicella","PCV booster","DTwP B1/DTaP B1","OPV 4* / OPV4 + IPV B1","Hib B1","Hepatitus A2",
                                    "Typhoid 1#","DTwP B2/DTaP B2","OPV5","MMR2$","Typhoid 2","Varicella 2$$","Tdap/Td & HPV^"};
    VaccinationScheduleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.vaccinationschedule);
        toolbar=(Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Tika Karan");
        String data=getIntent().getExtras().getString("dob");
        String token[]=data.split("\\s+");
        tDate=token[1];
        String bname=token[0];
        tv=(TextView)findViewById(R.id.babyname);
        tv.setText(bname);
        String[] dates = new String[] {tDate,tDate,tDate,change6weeks(tDate),change6weeks(tDate),change6weeks(tDate),
                change6weeks(tDate), change6weeks(tDate),change6weeks(tDate),change10weeks(tDate),change10weeks(tDate),
                change10weeks(tDate),
                change10weeks(tDate),change10weeks(tDate),change14weeks(tDate),change14weeks(tDate),change14weeks(tDate),
                change14weeks(tDate),change14weeks(tDate),change9months(tDate),change1year(tDate),change15month(tDate)
                ,change15month(tDate),change15month(tDate),change17month(tDate),change17month(tDate),change17month(tDate),
                change18month(tDate),change2years(tDate),change5years(tDate),change5years(tDate),change5years(tDate),
                change5years(tDate),change5years(tDate),change11years(tDate)};


       /* String[] dates = new String[] {"1295","2154","1295","1295","1295","1295", "1295", "1295","1295","1295","1295",
                "1295", "1295","1295","1295","1295","1295", "1295","1295","1295","1295","1295","1295","1295",
                "1295","1295","1295", "1295","1295","1295","1295","1295", "1295","1295","1295","1295","1295"};*/

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        int i=0;
        adapter=new VaccinationScheduleAdapter(VaccinationSchedule.this,R.layout.vaccinationschedulerowlayout);
        listView.setAdapter(adapter);
        for(String vaccinename: values){
            VaccinationDataProvider vaccinationDataProvider=new VaccinationDataProvider(vaccinename,dates[i]);
            adapter.add(vaccinationDataProvider);

            i++;
        }



    }

    public void tnc(View v){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(VaccinationSchedule.this);
        alertDialogBuilder.setTitle("Terms and Condition");
        alertDialogBuilder.setMessage("*OPV alone if IPV cannot be given \n *#Rotavirus vaccine (2/3) doses depending on the brand at 4-8 weeks interval \n **the third dose of Hepatitis B can be given at 6 months \n $ the second dose of MMR vaccine can be given at anytime 4-8 weeks after the first dose \n $$Varicella (second dose maybe given anytime 3 months after 1st dose) \n #Typhoid revaccination every 3 years and Tdap prefered to td,followed by repeat Td every 10years \n ^only females, 3 doses at 0, 1-2(depending on brands)and 6months");

        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }





    public String change6weeks(String dates){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dates));

        }
        catch(Exception e){}

        c.add(Calendar.DATE,42);
        dates = sdf.format(c.getTime());

        return dates;
    }
    public String change10weeks(String dates){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dates));
        }
        catch(Exception e){}
        c.add(Calendar.DATE,70);
        dates = sdf.format(c.getTime());

        return dates;
    }
    public String change14weeks(String dates){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dates));
        }
        catch(Exception e){}
        c.add(Calendar.DATE,98);
        dates = sdf.format(c.getTime());

        return dates;
    }

    public String change9months(String dates){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dates));
        }
        catch(Exception e){}
        c.set(Calendar.MONTH,c.get(Calendar.MONTH)+9);
        dates = sdf.format(c.getTime());

        return dates;
    }


    public String change1year(String dates){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dates));
        }
        catch(Exception e){}
        c.set(Calendar.YEAR,c.get(Calendar.YEAR)+1);
        dates = sdf.format(c.getTime());

        return dates;
    }

    public String change15month(String dates){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dates));
        }
        catch(Exception e){}
        c.add(Calendar.DATE,365+140);
        dates = sdf.format(c.getTime());

        return dates;
    }

    public String change17month(String dates){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dates));
        }
        catch(Exception e){}
        c.add(Calendar.DATE,365+196);
        dates = sdf.format(c.getTime());

        return dates;
    }
    public String change18month(String dates){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dates));
        }
        catch(Exception e){}
        c.add(Calendar.DATE,365+224);
        dates = sdf.format(c.getTime());

        return dates;
    }
    public String change2years(String dates){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dates));
        }
        catch(Exception e){}
        c.set(Calendar.YEAR,c.get(Calendar.YEAR)+2);
        dates = sdf.format(c.getTime());

        return dates;
    }

    public String change5years(String dates){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dates));
        }
        catch(Exception e){}
        c.set(Calendar.YEAR,c.get(Calendar.YEAR)+5);
        dates = sdf.format(c.getTime());

        return dates;
    }
    public String change11years(String dates){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dates));
        }
        catch(Exception e){}
        c.set(Calendar.YEAR,c.get(Calendar.YEAR)+11);
        dates = sdf.format(c.getTime());

        return dates;
    }
}
