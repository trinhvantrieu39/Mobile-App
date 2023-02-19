package com.example.country;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DetailCountry extends AppCompatActivity {

    private ImageView flag;
    private TextView countryname;
    private TextView population;
    private TextView area;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_country);
        Country c = new Country();
        c = (Country) getIntent().getSerializableExtra("Detail");

        String km2 = " km\u00B2";
        int n =  Integer.parseInt(c.getPopulation());
        String temp = NumberFormat.getNumberInstance(Locale.getDefault()).format(n);

        flag = findViewById(R.id.flag);
        countryname = findViewById(R.id.countryname);
        population = findViewById(R.id.population);
        area = findViewById(R.id.area);
        imageView = findViewById(R.id.map);
        countryname.setText("CountryName: "+c.getCountryName());
        population.setText("Population: "+temp);
        area.setText("Area: "+c.getArea()+km2);
        String url1 = "https://img.geonames.org/flags/x/"+c.getCountryCode().toLowerCase()+".gif";
        String url2 = "https://img.geonames.org/img/country/250/"+c.getCountryCode()+".png";

        //Picasso.get().load(url).into(imageView);
        ItemAdapter.PicassoTrustAll.getInstance(this).load(url1).placeholder(R.drawable.loading).into(flag);
        ItemAdapter.PicassoTrustAll.getInstance(this).load(url2).placeholder(R.drawable.loading).into(imageView);
    }
}