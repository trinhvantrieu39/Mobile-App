package com.example.curency;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class AdapterHistory extends BaseAdapter {
    private List<history_exchange> list;
    private Context context;

    public AdapterHistory(List<history_exchange> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_history, null);
        TextView cou1 = view.findViewById(R.id.start);
        TextView cou2 = view.findViewById(R.id.end);
        TextView mon1 = view.findViewById(R.id.money_start);
        TextView mon2 = view.findViewById(R.id.money_end);
        TextView dv1 = view.findViewById(R.id.dv_money1);
        TextView dv2 = view.findViewById(R.id.dv_money2);

        cou1.setText(list.get(i).getName1());
        cou2.setText(list.get(i).getName2());
        mon1.setText(list.get(i).getMoney1());
        mon2.setText(list.get(i).getMoney2());
        dv1.setText(list.get(i).getDv1());
        dv2.setText(list.get(i).getDv2());
        return view;


    }
}
