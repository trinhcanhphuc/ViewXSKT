package com.example.trinhcanhphuc.viewxskt;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.concurrent.ExecutionException;


//Home activity
public class MainActivity extends AppCompatActivity {

    ListView listTDXS;
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    int result = 0;

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

        //if mobile connected internet then download xml file, update database and display
        if (checkInternetConnection()) {
            try {
                new AsyncDownloadJsonFile(MainActivity.this, "http://thanhhungqb.tk:8080/kqxsmn",
                        result).execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            /*if(result == 1)
                Toast.makeText(getApplicationContext(), "download success", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "download not success", Toast.LENGTH_SHORT).show();*/

        }
        else{
            String path = getApplicationContext().getFilesDir().getAbsolutePath()+"/xskt.json";
            File file = new File ( path );
            if ( file.exists() )
            {
                Toast.makeText(getApplicationContext(), "File exists", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "File not exists", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean checkInternetConnection() {
        //get Connectivity Manager object to check connection
        ConnectivityManager conn = (ConnectivityManager) getSystemService(
                getBaseContext().CONNECTIVITY_SERVICE);
        //check for network connection
        if (conn.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                conn.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {

            Toast.makeText(this, " Connected Internet", Toast.LENGTH_LONG).show();
            return true;
        } else if (conn.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                conn.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                conn.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                conn.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, " Not Connected Internet", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }
}
