package com.parks.albertan.albertssfparks.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class JsonReader {

  public static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    Log.d("here", "i'm here4");

    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    Log.d("here", "i'm here5");
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    Log.d("here", "i'm here3");
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      
      String jsonText = readAll(rd);
      Log.d("here", "rd!");
      JSONObject json = new JSONObject(jsonText);
      Log.d("here", "jsonob");
      return json;
    } finally {
      is.close();
    }
  }
  
  public static JSONArray readJsonArrayFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);


	      JSONArray thisjsonarray = new JSONArray(jsonText);

           Log.d("this array", "this "+thisjsonarray);

	      return thisjsonarray;


	    } finally {
	      is.close();
	    }
	}

   public ArrayList<String> JsonConvertArraylist(JSONArray arrayjson){

       ArrayList<String> listdata = new ArrayList<String>();
       JSONArray jArray = arrayjson;
       if (jArray != null) {

           for (int i=0;i<jArray.length();i++){
               try {

                   listdata.add(jArray.get(i).toString());

               }catch (JSONException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
               }
           }
       }//end if

       return listdata;

   }
	  
}
