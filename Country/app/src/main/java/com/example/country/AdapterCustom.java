package com.example.country;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Locale;

//custom lai adapter theo y minh
public class AdapterCustom extends ArrayAdapter<Country> {
    Context context;
    int resource;
    List<Country> objects;
    Drawable mDraw = null;
    public AdapterCustom(Context context, int resource, List<Country> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }
//
    private class ViewHolder {
    TextView name;
    TextView code;
    TextView currency;
    ImageView imageView;
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder Holder;
        if(convertView == null)
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview, parent,false);
            Holder = new ViewHolder();
            Holder.name = convertView.findViewById(R.id.countryname);
//            Holder.code = convertView.findViewById(R.id.countrycode);
//            Holder.currency = convertView.findViewById(R.id.currencycode);
            Holder.imageView = convertView.findViewById(R.id.imageView);
            convertView.setTag(Holder);
        } else {
            Holder = (ViewHolder) convertView.getTag();
        }

        Country country = objects.get(position);
        Holder.name.setText(country.getCountryName());
        Holder.code.setText(country.getCountryCode() + " - ");
        Holder.currency.setText(country.getCurrencyCode());
        String url = "https://img.geonames.org/flags/x/"+objects.get(position).getCountryCode().toLowerCase()+".gif";
        Picasso.get().load(url).into(Holder.imageView);

        return  convertView;
    }
}
