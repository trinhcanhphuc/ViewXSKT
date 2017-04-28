package com.example.trinhcanhphuc.viewxskt;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import static android.content.Context.MODE_WORLD_READABLE;

/**
 * Created by tcp on 4/7/17.
 */

public class AsyncDownloadJsonFile extends AsyncTask<Void , String, Integer> {

    private Context context;
    private String f_url = "";
    //private boolean isNetworkConnected;
    private int result = 0;

    /**
     * Before starting background thread
     * Show Progress Bar Dialog
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //showDialog(progress_bar_type);
    }

    public AsyncDownloadJsonFile(Context context, String f_url, int result){
        this.context = context;
        this.f_url = f_url;
        this.result = result;
        //this.isNetworkConnected = isNetworkConnected;
    }

    /**
     * Downloading file in background thread
     */
    @Override
    protected Integer doInBackground(Void... params) {
        int count;
        //if(isNetworkConnected) {
            try {
                URL url = new URL(f_url);
                URLConnection connection = url.openConnection();
                connection.connect();
                // this will be useful so that you can show a tipical 0-100% progress bar
                int lenghtOfFile = connection.getContentLength();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream(), 8192);

                // Output stream
                OutputStream output = context.openFileOutput("xskt.json", MODE_WORLD_READABLE);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }
        //}

        return null;
    }

    /**
     * After completing background task
     * Dismiss the progress dialog
     * **/
    @Override
    protected void onPostExecute(Integer result) {
        //readFromInternal("currency.xml");
        //readFromDatabase("currency.xml");
        result = 1;
    }
}