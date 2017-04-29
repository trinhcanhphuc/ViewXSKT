package com.example.trinhcanhphuc.viewxskt;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class InforDateTD extends AppCompatActivity {

    TextView txtNum;
    String nameTongDai;
    TongDai tongDai;
    ListView lvDays;
    String[] days;
    ArrayAdapter adapter;
    private static FragmentManager fragmentManager;

    Fragment argumentFragment;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_date_td);

        fragmentManager = getSupportFragmentManager();

        txtNum = (TextView) findViewById(R.id.txtNum);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        txtNum.setText(b.getString("TongDai"));
        nameTongDai = b.getString("TongDai");
        tongDai = (TongDai) b.getSerializable("Info");

        lvDays = (ListView) findViewById(R.id.lvDays);
        days = new String[tongDai.getKqsxDays().size()];
        for(int i = 0; i < days.length; i++){
            days[i] = String.valueOf(tongDai.getKqsxDays().get(i).getDate());
        }
        adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1, days);
        lvDays.setAdapter(adapter);
        lvDays.setBackgroundColor(Color.BLUE);

        argumentFragment = new ListNumTTFragment();//Get Fragment Instance
        bundle = new Bundle();

        lvDays.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lvDays.setEnabled(false);
                lvDays.setVisibility(View.INVISIBLE);
                bundle.putInt("numDay", position);
                bundle.putSerializable("info", tongDai);
                argumentFragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, argumentFragment).commit();
            }
        });

        //Finally set argument bundle to fragment
        /*Fragment argumentFragment = new ListNumTTFragment();//Get Fragment Instance
        Bundle bundle = new Bundle();
        bundle.putString("tongDai", nameTongDai);
        bundle.putSerializable("info", tongDai);
        argumentFragment.setArguments(bundle);//Finally set argument bundle to fragment*/



    }
}
