package com.example.trinhcanhphuc.viewxskt;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


//Home activity
public class MainActivity extends AppCompatActivity {

    ListView listTDXS;
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    int result = 0;

    private String TAG = MainActivity.class.getSimpleName();

    ArrayList<TongDai> tongDais;

    ArrayList<HashMap<String, String>> tongDaiList;

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
        /*if (checkInternetConnection()) {
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
                Toast.makeText(getApplicationContext(), "download not success", Toast.LENGTH_SHORT).show();

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
        }*/

        /***
         * Read from JSONFile and return data
         */


        tongDaiList = new ArrayList<>();

        new GetKQSX().execute();

    }


    private class GetKQSX extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "http://thanhhungqb.tk:8080/kqxsmn";
            String jsonStr = sh.makeServiceCall(url);

            //Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    // Getting JSON Object list tongDai node
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    Iterator x = jsonObj.keys();
                    JSONArray jsonTongDais = new JSONArray();

                    //Log.e(TAG, "tong dai: " + jsonObj);

                    Log.e(TAG, "amount tong dai: " + jsonObj.length());

                    tongDais = new ArrayList<>();

                    //for(int amountTongDais = 0 ; amountTongDais < jsonObj.length();amountTongDais++){
                        int indexTongDai = 0;
                        while (x.hasNext()) {
                            String key = (String) x.next();
                            jsonTongDais.put(jsonObj.get(key));
                            //Log.e(TAG, key + " : " + jsonObj.get(key));
                            TongDai tongDai = new TongDai();
                            tongDai.setName(key);
                            tongDais.add(tongDai);

                            JSONObject jsonObjTD = (JSONObject) jsonTongDais.get(indexTongDai);

                            Iterator y = jsonObjTD.keys();
                            JSONArray jsonTongDai = new JSONArray();

                            ArrayList<KQSXDate> kqxsDays = new ArrayList<>();

                            int indexDay = 0;
                            while (y.hasNext()) {
                                String keyDate = (String) y.next();
                                jsonTongDai.put(jsonObjTD.get(keyDate));
                                //Log.e(TAG, key + " : " + jsonObjTD.get(keyDate));
                                KQSXDate kqsxDate = new KQSXDate();
                                kqsxDate.setDate(keyDate);
                                kqxsDays.add(kqsxDate);

                                JSONObject jsonObjPrize = (JSONObject) jsonTongDai.get(indexDay);
                                Iterator z = jsonObjPrize.keys();
                                JSONArray jsonPrizes = new JSONArray();

                                int item = 0;
                                while (z.hasNext()) {

                                    ArrayList<String> prize = new ArrayList<>();
                                    String keyPrize = (String) z.next();
                                    jsonPrizes.put(jsonObjPrize.get(keyPrize));

                                    //Log.e(TAG, "Item Prize : " + jsonPrizes.get(item));

                                    JSONArray jsonItemPrize = jsonPrizes.getJSONArray(item);

                                    Log.e(TAG, "Item Prize: " + jsonItemPrize);

                                    for(int k = 0; k < jsonItemPrize.length(); k++)
                                    {
                                        prize.add((String)jsonItemPrize.get(k));
                                    }

                                    switch (item){
                                        case 0:
                                            kqxsDays.get(indexDay).setFirst_prize(prize);
                                            break;
                                        case 1:
                                            kqxsDays.get(indexDay).setSecond_prize(prize);
                                            break;
                                        case 2:
                                            kqxsDays.get(indexDay).setThird_prize(prize);
                                            break;
                                        case 3:
                                            kqxsDays.get(indexDay).setFourth_prize(prize);
                                            break;
                                        case 4:
                                            kqxsDays.get(indexDay).setFifth_prize(prize);
                                            break;
                                        case 5:
                                            kqxsDays.get(indexDay).setSixth_prize(prize);
                                            break;
                                        case 6:
                                            kqxsDays.get(indexDay).setSeventh_prize(prize);
                                            break;
                                        case 7:
                                            kqxsDays.get(indexDay).setEighth_prize(prize);
                                            break;
                                        case 8:
                                            kqxsDays.get(indexDay).setSpecial_prize(prize);
                                            break;
                                    }

                                    item++;
                                }

                                //Log.e(TAG, "First Prize : " + jsonPrizes.get(0));

                                //Log.e(TAG, "Third Prize : " + jsonPrizes.get(2));

                                //JSONArray jsonThirdPrize = jsonPrizes.getJSONArray(2);

                                //Log.e(TAG, "Second Prize number two: " + jsonThirdPrize.get(1));

                                indexDay++;

                            }
                            tongDais.get(indexTongDai).setKqsxDays(kqxsDays);

                            indexTongDai++;
                        }

                    //}

                    /*for(int amountTongDais = 0; amountTongDais < tongDais.size(); amountTongDais++){
                        //jsonTongDais.get(amountTongDais);
                        //tongDais.get()
                    }
                    while (x.hasNext()) {
                        String key = (String) x.next();
                        jsonTongDais.put(jsonObj.get(key));
                        //Log.e(TAG, key + " : " + jsonObj.get(key));
                    }

                    Log.e(TAG, "AG : " + jsonTongDais.get(0));

                    JSONObject jsonObjTD = (JSONObject) jsonTongDais.get(0);

                    //Log.e(TAG, "AG : " + jsonObjTD);

                    Iterator y = jsonObjTD.keys();
                    JSONArray jsonTongDaiAG = new JSONArray();
                    while (y.hasNext()) {
                        String key = (String) y.next();
                        jsonTongDaiAG.put(jsonObjTD.get(key));
                        Log.e(TAG, key + " : " + jsonObjTD.get(key));
                    }

                    Log.e(TAG, "AG Prize Days : " + jsonTongDaiAG);

                    JSONObject jsonObjPrize = (JSONObject) jsonTongDaiAG.get(0);
                    Iterator z = jsonObjPrize.keys();
                    JSONArray jsonPrizes = new JSONArray();
                    while (z.hasNext()) {
                        String key = (String) z.next();
                        jsonPrizes.put(jsonObjPrize.get(key));
                        Log.e(TAG, key + " : " + jsonObjPrize.get(key));
                    }

                    Log.e(TAG, "Prizes : " + jsonPrizes);

                    Log.e(TAG, "First Prize : " + jsonPrizes.get(0));

                    Log.e(TAG, "Third Prize : " + jsonPrizes.get(2));

                    JSONArray jsonThirdPrize = jsonPrizes.getJSONArray(2);

                    Log.e(TAG, "Second Prize number two: " + jsonThirdPrize.get(1));*/

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.d("tag", "finish");
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
