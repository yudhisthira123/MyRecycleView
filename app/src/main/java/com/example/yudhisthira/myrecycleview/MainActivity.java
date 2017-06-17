package com.example.yudhisthira.myrecycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(gridLayoutManager);

//        ArrayList<ColorPalatte> palettes = new ArrayList<>();
//        palettes.add(new ColorPalatte("RED", "#D32F2F", Color.parseColor("#d32f2f")));
//        palettes.add(new ColorPalatte("PINK", "#FF4081", Color.parseColor("#ff4081")));
//        palettes.add(new ColorPalatte("INDIGO", "#7B1FA2", Color.parseColor("#7b1fa2")));
//        palettes.add(new ColorPalatte("BLUE", "#536DFE", Color.parseColor("#536dfe")));
//        palettes.add(new ColorPalatte("GREEN", "#388E3C", Color.parseColor("#388e3c")));
//        palettes.add(new ColorPalatte("ORANGE", "#FF5722", Color.parseColor("#ff5722")));
//        palettes.add(new ColorPalatte("AMBER", "#FFA000", Color.parseColor("#ffa000")));

        List<Item> itemList = new ArrayList<>();

        itemList.add(new Item("", "name1", "address1"));
        itemList.add(new Item("", "name2", "address2"));
        itemList.add(new Item("", "name3", "address3"));
        itemList.add(new Item("", "name4", "address4"));
        itemList.add(new Item("", "name5", "address5"));
        itemList.add(new Item("", "name6", "address6"));
        itemList.add(new Item("", "name7", "address7"));
        itemList.add(new Item("", "name8", "address8"));
        itemList.add(new Item("", "name9", "address9"));
        itemList.add(new Item("", "name10", "address10"));


        recyclerView.setAdapter(new ListAdapter(this, itemList));
    }
}
