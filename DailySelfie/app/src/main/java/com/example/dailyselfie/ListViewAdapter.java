package com.example.dailyselfie;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Image> hinhanhList;


    public ListViewAdapter(Context context, List<Image> imaList) {
        this.context = context;
        this.hinhanhList = imaList;
    }

    @Override
    public int getCount() {
        return hinhanhList.size();
    }

    @Override
    public Object getItem(int i) {
        return hinhanhList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.listview_row, null);
        ImageView image = view.findViewById(R.id.imageViewGrid);
        TextView text = view.findViewById(R.id.textViewGrid);
        image.setImageBitmap(hinhanhList.get(i).getBitmap());
        text.setText(hinhanhList.get(i).getName());
        return view;
    }
}
