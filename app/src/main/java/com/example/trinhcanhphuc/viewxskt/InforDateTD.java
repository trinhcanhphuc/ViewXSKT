package com.example.trinhcanhphuc.viewxskt;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InforDateTD extends Activity {

    TextView txtNum;
    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_date_td);

        txtNum = (TextView) findViewById(R.id.txtNum);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        txtNum.setText(String.valueOf(b.getInt("num")));
        num = b.getInt("num");
    }

    public void FragmentOneClick(View view) {
        Fragment myfragment;
        myfragment = new FragmentOne();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, myfragment);
        fragmentTransaction.commit();
    }

    public void FragmentTwoClick(View view) {
        Fragment myfragment;
        myfragment = new FragmentTwo();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, myfragment);
        fragmentTransaction.commit();

    }
}
