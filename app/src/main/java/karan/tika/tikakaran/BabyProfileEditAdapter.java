package karan.tika.tikakaran;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AlertDialog;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.CheckBox;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

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


public class BabyProfileEditAdapter extends ArrayAdapter {
    List list=new ArrayList();



    public BabyProfileEditAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }






    static class DataHandler {
        TextView babyName;
        TextView dates;
        ImageView babyImage;


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
            view= inflater.inflate(R.layout.babyprofilerowlayout,parent,false);
            handler=new DataHandler();
            handler.babyName=(TextView) view.findViewById(R.id.BabyName);
            handler.dates=(TextView) view.findViewById(R.id.Dateofbirth);
            handler.babyImage=(ImageView) view.findViewById(R.id.ImageView);
            view.setTag(handler);

        }


        else{

            handler=(DataHandler) view.getTag();
        }

        BabyProfileDataProvider babyProfileDataProvider=(BabyProfileDataProvider) this.getItem(position);
        handler.babyName.setText(babyProfileDataProvider.getBabyName());
        handler.dates.setText(babyProfileDataProvider.getDates());




        return view;
    }
}

