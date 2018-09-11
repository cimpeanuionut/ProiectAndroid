package com.example.gabriel.myfirstgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriel on 27/01/2017.
 */

public class listviewactivity extends Activity {

    private ListView lvListview;
    private listviewadapter adapter;
    private List<listview> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);
        lvListview = (ListView) findViewById(R.id.listview);
        mList = new ArrayList<>();
        mList.add(new listview("Ionut", 100, 1234));
        mList.add(new listview("Mihai", 50, 784));
        mList.add(new listview("Alexandru", 79, 984));
        mList.add(new listview("Cornel", 150, 1535));
        mList.add(new listview("Dumitru", 234, 2435));

        adapter= new listviewadapter(getApplicationContext(),mList);
        lvListview.setAdapter(adapter);
        lvListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Scorul jucatorului selectat este  " + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
