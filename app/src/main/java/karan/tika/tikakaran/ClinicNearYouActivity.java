package karan.tika.tikakaran;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shreya on 11/4/2016.
 */

public class ClinicNearYouActivity extends AppCompatActivity {
    Toolbar toolbar;
   ListView listView;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clinicnearyou);
        tv = (TextView) findViewById(R.id.textView);
        toolbar=(Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Tika Karan");


        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

    // Defined Array values to show in ListView

        String[] values = new String[] {"Ghaziabad","Delhi","Noida"};

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;
                TextView clickedView = (TextView) view;


                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                //show dialog



                if(itemValue.equals("Delhi")){

                    tv.setText("Dr Vineeta Rajputs New Born Child Vaccination Centre \n +(91)-9999677575, 9811161345 \n D-2/99, Janakpuri, Delhi - 110058, Behind Bhagat Hospital \n \n Child Clinic & Vaccination Centre \n +(91)-9999383135 \n B-9, Lajpat Nagar, Delhi - 110024, Part-1 \n\n Child Health Centre \n +(91)-11-26272061, 40548313 \n F-1203, C R Park, Delhi - 110019, Near Market Number-2 \n " + "Child Care Medical Centre \n" +
                            "+(91)-11-45035060, 45088578\n" +
                            "•\t+(91)-9810484506, 8010808888\n" +
                            "•\t3/11, West Patel Nagar, Delhi - 110008, Balraj khanna marg \n" +
                            "\n" +
                            "\n" +
                            "Child Clinic & Vaccination Center\n" +
                            "+(91)-9582151369, 9968488953\n" +
                            "•\tC-5/76, Rohini Sector 11, Delhi - 110085, Near Raj Car Accessories\n" +
                            "\n" +
                            "Child Clinic & Vaccination Centre\n" +
                            "+(91)-9811056573\n" +
                            "•\t7A/44 WEA, Channa Market , Karol Bagh, Delhi - 110005, Opp Mother Dairy \n");
                }
                else if(itemValue.equals("Ghaziabad")){

                tv.setText("Shiv Krishna Hospital\n" +
                        "+(91)-120-2635000\n" +
                        "•\t+(91)-8800190599, 8800190600\n" +
                        "•\tD-494, Lajpat Nagar, Sahibabad, Ghaziabad - 201005, Near Hindon Air Force Station \n" +
                        "\n" +
                        "Mishras Clinic \n" +
                        "B 361, 362, Block-B, Lajpat Nagar-Sahibabad, Ghaziabad - 201005, Near Jagdamba Sweets\n" +
                        "\n" +
                        "\n" +
                        "Dr Dinesh Kapil\n" +
                        "+(91)-11-22597363, 22597558\n" +
                        "•\t+(91)-9810389210 , +(91)-9560567264 \n" +
                        "•\t103, Mantri Arcade, Dilshad Garden, Delhi - 110095, B & E Market, Near SAI Chowk \n" +
                        "\n" +
                        "Kid Cure Clinic \n" +
                        "+(91)-11-33413186\n" +
                        "•\tSHOP NO-49,ground floor,GDA COMPLEX, Indirapuram, Ghaziabad - 201014, NEAR BIJLI GHAR \n" +
                        "\n" +
                        "Ghai Mother And Child Health\n" +
                        "+(91)-11-33431682\n" +
                        "•\tPath Care Lab, Upper Ground Floor 6, Ajnara Arcade, Crossing Republik, Ghaziabad - 201016, Near Crossing Gol Chakkar \n" +
                        "\n" +
                        "Dr Mohit Jain Children Clinic\n" +
                        "+(91)-11-33743342\n" +
                        "•\tB-159, Sector 14, Noida - 201301, Near B Block Park \n" +
                        "Shishu Mangal Child Clinic\n" +
                        "+(91)-11-33066213\n" +
                        "•\tPlot Number 122, Vaishali Sector 4, Ghaziabad - 201010, Near Aditi And Paras Hospital\n");}
                else if(itemValue.equals("Noida")){
                    tv.setText("Maheshwari Clinic\n" +
                            "+(91)-120-6500680\n" +
                            "•\t+(91)-9717082258, 9643366850\n" +
                            "•\tD-292,SEC-108, near DIVINE MEADOWS APARTMENTS, Sector 108, Noida - 201304, Near CNG PUMP-SEC 105 \n" + "Dr Shilpi Gupta\n +(91)-11-33087199 \n 7 B1, Sector 50, Noida - 201307, Gopalas sweets, Central market Sector 50\n\n Manas Hospital  \n +(91)-11-33429787 \n A 93, Sector 34, Noida - 201307, Cng Petrol Pump \n\n India IVF Clinic \n +(91)-11-33725911\n 1st Ffloor, Chikitsa NMC Super Spacialtity, 16C, Block E, Sector 30, Noida – 201303\n\n Empathy Medcare \n +(91)-120-4228444, 4247222, 4262555 \n +(91)-9987703815, 9717077057 \n Shop Number 8 A 3/8, Main Market, Sector 110, Noida - 201304, Near Dominos Pizza ");
                    }








            }

        });  }


}
