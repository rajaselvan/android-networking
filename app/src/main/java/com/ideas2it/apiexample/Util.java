package com.ideas2it.apiexample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Util {

  public static ArrayList<Places> retrievePlacesFromResponse(String response) throws
      JSONException {
    if (null == response) {
      return new ArrayList<>();
    }
    JSONArray jsonArray = new JSONArray(response);
    ArrayList<Places> placesArrayList = new ArrayList<>();

    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject jsonObject = jsonArray.getJSONObject(i);
      if (null != jsonObject) {
        Places places = new Places();
        if (jsonObject.has("Name")) {
          places.setName(jsonObject.getString("Name"));
        }
        if (jsonObject.has("Address")) {
            places.setAddress(jsonObject.getString("Address"));
        }
        if (jsonObject.has("Date")) {
            places.setDate(jsonObject.getString("Date"));
        }
        if (jsonObject.has("Url")) {
          places.setImageUrl(jsonObject.getString("Url"));
        }
        placesArrayList.add(places);
      }
    }
    return placesArrayList;
  }
}
