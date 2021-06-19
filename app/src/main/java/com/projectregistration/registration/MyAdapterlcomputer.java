package com.projectregistration.registration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapterlcomputer extends ArrayAdapter<Employeecomputerscience> {

    Context context;
    List<Employeecomputerscience> arrayListEmployeecomputerscience;


    public MyAdapterlcomputer(@NonNull Context context, List<Employeecomputerscience> arrayListEmployeecomputerscience) {
        super(context, R.layout.custom_list_itemcomputer, arrayListEmployeecomputerscience);

        this.context = context;
        this.arrayListEmployeecomputerscience = arrayListEmployeecomputerscience;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_itemcomputer,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvCoursee = view.findViewById(R.id.txt_coursee);

        tvID.setText(arrayListEmployeecomputerscience.get(position).getId());
        tvCoursee.setText(arrayListEmployeecomputerscience.get(position).getCoursee());

        return view;
    }
}
