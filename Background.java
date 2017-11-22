package it.itspiemonte.pietro.newsapplication;

import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Pietro on 22/11/2017.
 */

public class Background extends AsyncTask<URL, Void, String> {



    protected String doInBackground(URL... urls) {

        GetJson getAPI = new GetJson();
        String response = null;
        try {
            response = getAPI.run(urls[0].toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    protected void onProgressUpdate(Integer... progress) {

    }

    protected void onPostExecute(String response) {
        if (response != null) {

                JSONObject jsonObj = null;
                try {
                    jsonObj = new JSONObject(response);
                    // Getting JSON Array node
                    JSONArray articles = jsonObj.getJSONArray("articles");

                    // looping through All Contacts
                    for (int i = 0; i < articles.length(); i++) {
                        JSONObject c = articles.getJSONObject(i);
                        String author = c.getString("author");
                        String title = c.getString("title");
                        String description = c.getString("description");


                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("author", author);
                        contact.put("title", title);
                        contact.put("description", description);


                        // adding contact to contact list
                       //to be continued
                    }

                } catch (JSONException e) {

                    e.printStackTrace();
                }


            }
        }
    }

