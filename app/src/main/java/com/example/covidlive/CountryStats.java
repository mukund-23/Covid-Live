package com.example.covidlive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountryStats extends AppCompatActivity {


    EditText editText;
    ListView listView;
    SimpleArcLoader loader;


    public static List<CountryModel> countryModelList = new ArrayList<>();
    CountryModel countryModel;
    MyCustomAdapter myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_stats);

        editText = findViewById(R.id.editText);
        loader = findViewById(R.id.loader);
        listView = findViewById(R.id.listview);


        fetchData();


    }

    private void fetchData() {

        String url = "https://corona.lmao.ninja/v2/countries";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            for(int i = 0; i < jsonArray.length(); i++){

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String countryName = jsonObject.getString("country");
                                String cases = jsonObject.getString("cases");
                                String todayCases = jsonObject.getString("todayCases");
                                String active = jsonObject.getString("active");
                                String recovered = jsonObject.getString("recovered");
                                String deaths = jsonObject.getString("deaths");
                                String todayDeaths = jsonObject.getString("todayDeaths");
                                String critical = jsonObject.getString("critical");

                                JSONObject object = jsonObject.getJSONObject("countryInfo");
                                String flagUrl = object.getString("flag");

                                countryModel = new CountryModel(flagUrl,  countryName, cases, todayCases, recovered, deaths,  todayDeaths, active, critical);

                                countryModelList.add(countryModel);
                            }


                            myCustomAdapter = new MyCustomAdapter(CountryStats.this, countryModelList);
                            listView.setAdapter(myCustomAdapter);
                            loader.stop();
                            loader.setVisibility(View.GONE);




                        } catch (JSONException e) {
                            e.printStackTrace();
                            loader.stop();
                            loader.setVisibility(View.GONE);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loader.stop();
                loader.setVisibility(View.GONE);
                Toast.makeText(CountryStats.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }
}
