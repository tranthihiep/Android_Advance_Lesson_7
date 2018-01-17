package com.haha.lesson_7;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecycler;
    ArrayList<Information> informationArrayList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycler= (RecyclerView) findViewById(R.id.recycler);
        informationArrayList = new ArrayList<>();
        new ReadInfoFromJSon().execute("https://api.github.com/users/google/repos");

    }
    class ReadInfoFromJSon extends AsyncTask<String,Integer,String>{

     @Override
     protected String doInBackground(String... strings) {
         return readFromURL(strings[0]);
     }

     @Override
     protected void onPostExecute(String s) {
         super.onPostExecute(s);
         try {
             JSONArray jSArray = new JSONArray(s);
             for (int i = 0 ; i<jSArray.length();i++){
                 JSONObject jSObject = jSArray.getJSONObject(i);
                 informationArrayList.add(new Information(jSObject.getString("id"),jSObject.getString("name"),
                         jSObject.getString("full_name")));
             }
             setAdapter(informationArrayList);
         } catch (JSONException e) {
             e.printStackTrace();
         }
     }
 }
 private void setAdapter(ArrayList<Information> info){
     AdapterInfor adapter = new AdapterInfor(info);
     mRecycler.setAdapter(adapter);
     LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
     mRecycler.setLayoutManager(layoutManager);
     DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(MainActivity.this,layoutManager.getOrientation());
     mRecycler.addItemDecoration(dividerItemDecoration);

 }
    private String readFromURL(String theUrl){
        StringBuilder stringBuilder = new StringBuilder();
        try    {
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
