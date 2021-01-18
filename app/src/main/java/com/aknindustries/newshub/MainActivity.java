package com.aknindustries.newshub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewsItemClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewsListAdaptor newsListAdaptor = new NewsListAdaptor(fetchData(), this);
        recyclerView.setAdapter(newsListAdaptor);
    }

    private ArrayList<String> fetchData() {
        ArrayList<String> newsItems = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            newsItems.add("Item no. " + (i+1));
        }
        return newsItems;
    }

    @Override
    public void onItemClicked(String item) {
        Toast.makeText(this, "Current item is " + item, Toast.LENGTH_SHORT).show();
    }
}