package karan.tika.tikakaran;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Shreya on 11/5/2016.
 */

public class VaccinationScheduleAdapter extends ArrayAdapter implements View.OnClickListener{
    List list=new ArrayList();
    TextView tv;


    public VaccinationScheduleAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public void onClick(View view) {


        tv=(TextView) view.findViewById(R.id.VacinnationText);
        String itemClicked=tv.getText().toString();

        //show dialog
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());


        if(itemClicked.equals("BCG")){
            alertDialogBuilder.setTitle("BCG");
            alertDialogBuilder.setMessage("Prevents TB & bladder cancer");}
        else if(itemClicked.equals("HepB2")&& itemClicked.equals("Hepatitus B1")&& itemClicked.equals("HepB3**")&& itemClicked.equals("Hepatitus A1")&& itemClicked.equals("Hepatitus A2")){
            alertDialogBuilder.setTitle("HepB");
            alertDialogBuilder.setMessage("Prevents Hepatitis B\n");}
        else if(itemClicked.equals("Poliovirus")){
            alertDialogBuilder.setTitle("Poliovirus");
            alertDialogBuilder.setMessage("Prevents Polio");}
        else if(itemClicked.equals("DTwP1/DTaP1")&& itemClicked.equals("DTwP2/DTaP2")&& itemClicked.equals("DTwP3/DTaP3")&& itemClicked.equals("DTwP B1/DTaP B1")&& itemClicked.equals("DTwP B2/DTaP B2")){
            alertDialogBuilder.setTitle("DTwP/DTaP");
            alertDialogBuilder.setMessage("Prevents Diphther ia, Tetanus & Pertussis\n");}
        else if(itemClicked.equals("Hib1")&& itemClicked.equals("Hib2")&& itemClicked.equals("Hib3")&& itemClicked.equals("Hib B1")){
            alertDialogBuilder.setTitle("Hib");
            alertDialogBuilder.setMessage("Prevents Infections caused by Bacteria");}
        else if(itemClicked.equals("PCV1")&& itemClicked.equals("PCV2")&& itemClicked.equals("PCV booster")){
            alertDialogBuilder.setTitle("PCV");
            alertDialogBuilder.setMessage("Prevents Pneumo nia\n");}
        else if(itemClicked.equals("Typhoid 1#")&& itemClicked.equals("Typhoid 2")){
            alertDialogBuilder.setTitle("Typhoid");
            alertDialogBuilder.setMessage("Prevents Typhoid Fever, Diarrhea\n");}
        else if(itemClicked.equals("MMR1")&& itemClicked.equals("MMR2$")){
            alertDialogBuilder.setTitle("MMR");
            alertDialogBuilder.setMessage("Prevents Measles, Mumps & Rubella\n");}
        else if(itemClicked.equals("Varicella")&& itemClicked.equals("Varicella 2$$")){
            alertDialogBuilder.setTitle("Varicella");
            alertDialogBuilder.setMessage("Prevents Chicken pox\n");}
        else if(itemClicked.equals("HepA")){
            alertDialogBuilder.setTitle("HepA");
            alertDialogBuilder.setMessage("Prevents Liver disease\n");}
        else if(itemClicked.equals("Tdap")){
            alertDialogBuilder.setTitle("Tdap");
            alertDialogBuilder.setMessage("Prevents Diphtheria, Tetanus & Pertussis\n");}
        else if(itemClicked.equals("HPV")){
            alertDialogBuilder.setTitle("HPV");
            alertDialogBuilder.setMessage("Prevents Some Cancers & Warts\n");}
        else if(itemClicked.equals("OPV0")&& itemClicked.equals("OPV1*/ OPV1 + IPV1")&& itemClicked.equals("OPV2* / OPV2 + IPV2")&& itemClicked.equals("OPV 3* / OPV3 + IPV3")&& itemClicked.equals("OPV 4* / OPV4 + IPV B1")&& itemClicked.equals("OPV5")){
            alertDialogBuilder.setTitle("OPV");
            alertDialogBuilder.setMessage("idk\n");}
        else if(itemClicked.equals("Tdap/Td & HPV^")){
            alertDialogBuilder.setTitle("Tdap/Td & HPV^");
            alertDialogBuilder.setMessage("idk\n");}
        else if(itemClicked.equals("Measles")){
            alertDialogBuilder.setTitle("Measles");
            alertDialogBuilder.setMessage("idk\n");}
        else if(itemClicked.equals("Oral Rotavirus 1 *#")&& itemClicked.equals("Oral Rotavirus 2")){
            alertDialogBuilder.setTitle("Oral Rotavirus");
            alertDialogBuilder.setMessage("idk\n");}





        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }




    static class DataHandler {
        TextView vaccineName;
        TextView dates;
        CheckBox hit;
        CheckBox miss;

    }






    @Override
    public int getCount() {
        return this.list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        DataHandler handler;

        if(convertView == null){
            LayoutInflater inflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(R.layout.vaccinationschedulerowlayout,parent,false);
            handler=new DataHandler();
            handler.vaccineName=(TextView) view.findViewById(R.id.VacinnationText);
            handler.dates=(TextView) view.findViewById(R.id.VacinnationDate);

            view.setTag(handler);

        }


        else{

            handler=(DataHandler) view.getTag();
        }

        VaccinationDataProvider vaccinationDataProvider=(VaccinationDataProvider) this.getItem(position);
        handler.vaccineName.setText(vaccinationDataProvider.getVaccinationName());
        handler.dates.setText(vaccinationDataProvider.getDates());
        view.setOnClickListener(this);





        return view;
    }




}
