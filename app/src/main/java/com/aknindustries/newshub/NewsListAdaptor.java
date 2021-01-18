package com.aknindustries.newshub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsListAdaptor extends RecyclerView.Adapter<NewsViewHolder> {

    private final ArrayList<String> items;
    private final NewsItemClicked newsItemClicked;

    NewsListAdaptor(ArrayList<String> items, NewsItemClicked newsItemClicked) {
        this.items = items;
        this.newsItemClicked = newsItemClicked;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(view);
        view.setOnClickListener(v -> this.newsItemClicked.onItemClicked(this.items.get(newsViewHolder.getAdapterPosition())));
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        String item = this.items.get(position);
        holder.titleView.setText(item);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
}

class NewsViewHolder extends RecyclerView.ViewHolder {

    TextView titleView;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.titleView = itemView.findViewById(R.id.title);
    }

}

interface NewsItemClicked {
    void onItemClicked(String item);
}
