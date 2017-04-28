package com.example.trinhcanhphuc.viewxskt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


//Home activity
public class MainActivity extends AppCompatActivity {

    ListView listTDXS;
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listTDXS = (ListView) findViewById(R.id.listTDXS);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mobileArray);

        listTDXS.setAdapter(adapter);

        listTDXS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b = new Bundle();
                b.putInt("num", position);
                Intent intent = new Intent(getApplicationContext(), InforDateTD.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
