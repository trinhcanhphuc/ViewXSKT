package com.example.trinhcanhphuc.viewxskt;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class InforDateTD extends AppCompatActivity {

    TextView txtNum;
    int num;
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_date_td);

        fragmentManager = getSupportFragmentManager();

        txtNum = (TextView) findViewById(R.id.txtNum);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        txtNum.setText(String.valueOf(b.getInt("num")));
        num = b.getInt("num");


        Fragment argumentFragment = new ListNumTTFragment();//Get Fragment Instance
        Bundle bundle = new Bundle();
        bundle.putInt("number", num);
        argumentFragment.setArguments(bundle);//Finally set argument bundle to fragment

        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, argumentFragment).commit();

    }
}
