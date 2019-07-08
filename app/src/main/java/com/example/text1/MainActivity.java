package com.example.text1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fondesa.recyclerviewdivider.RecyclerViewDivider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView dataView = findViewById(R.id.dataView);
        RecyclerViewDivider.with(this).build().addTo(dataView);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        dataView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        RecyclerViewDivider.with(this).build().addTo(recyclerView);
        //recyclerView.addItemDecoration(new MDGridRvDividerDecoration(this));

        recyclerView.setLayoutManager(new GridLayoutManager(this, 7, RecyclerView.VERTICAL, false));
        ArrayList<String> datas = new ArrayList<>();
        datas.add("cat");
        datas.add("dog");
        datas.add("cat");
        datas.add("dog");
        datas.add("cat");
        datas.add("dog");
        datas.add("cat");
        datas.add("dog");
        recyclerView.setAdapter(new Adapter(datas));
        dataView.setAdapter(new Adapter(datas, 7, true));

    }
}
