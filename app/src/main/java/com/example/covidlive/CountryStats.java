package com.example.covidlive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.leo.simplearcloader.SimpleArcLoader;

public class CountryStats extends AppCompatActivity {


    EditText editText;
    ListView listView;
    SimpleArcLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_stats);

        editText = findViewById(R.id.editText);
        loader = findViewById(R.id.loader);
        listView = findViewById(R.id.listview);


    }
}
