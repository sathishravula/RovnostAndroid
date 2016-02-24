package com.ehc.rovnostandroid.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ehc.rovnostandroid.R;
import com.weiwangcn.betterspinner.library.BetterSpinner;


public class MyProfile extends BaseActivity implements AdapterView.OnItemClickListener {


    private String[] bloodGroups;
    private String[] maritalStatus;
    private String[] feets;
    private String[] inches;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bloodGroups =getResources().getStringArray(R.array.blood_groups);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.simple_dropdown_item_1line, bloodGroups);
        BetterSpinner textView = (BetterSpinner)
                findViewById(R.id.bg_spinner);
        textView.setAdapter(adapter);
        textView.setOnItemClickListener(this);
//        textView.set
//        textView.setSelection(2);
        maritalStatus =getResources().getStringArray(R.array.marital_status);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.simple_dropdown_item_1line, maritalStatus);
        textView = (BetterSpinner)
                findViewById(R.id.marital_spinner);
        textView.setAdapter(adapter1);
        textView.setOnItemClickListener(this);
        feets =getResources().getStringArray(R.array.feets);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                R.layout.simple_dropdown_item_1line, feets);
        textView = (BetterSpinner)
                findViewById(R.id.feets_spinner);
        textView.setAdapter(adapter2);
        textView.setOnItemClickListener(this);
        inches =getResources().getStringArray(R.array.inches);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                R.layout.simple_dropdown_item_1line, inches);
        textView = (BetterSpinner)
                findViewById(R.id.inch_spinner);
        textView.setAdapter(adapter3);
        textView.setOnItemClickListener(this);



    }


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_my_profile;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, parent.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
    }
}
