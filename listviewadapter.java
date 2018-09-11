package com.example.gabriel.myfirstgame;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gabriel on 27/01/2017.
 */

public class listviewadapter extends BaseAdapter {

    private Context mContext;
    private List<listview> mListView;

    public listviewadapter(Context mContext, List<listview> mListView) {
        this.mContext = mContext;
        this.mListView = mListView;
    }

    @Override
    public int getCount() {
        return mListView.size();
    }

    @Override
    public Object getItem(int position) {
        return mListView.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View v = View.inflate(mContext,R.layout.itemlistview,null);

        TextView tvNume = (TextView)v.findViewById(R.id.nume);
        TextView tvScor = (TextView)v.findViewById(R.id.scor);
        TextView tvDistanta = (TextView)v.findViewById(R.id.distanta);


        tvNume.setText(mListView.get(position).getNume());
        tvScor.setText(String.valueOf(mListView.get(position).getScor()));
        tvDistanta.setText(String.valueOf(mListView.get(position).getDistanta()));

        v.setTag(mListView.get(position).getScor());

        return v;
    }
}
