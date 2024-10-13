package com.saidi.liveevents1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<recycler> {
    Context context;
    List<Item> items;

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public recycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new recycler(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull recycler holder, int position) {
        holder.dateConcertView.setText(items.get(position).getDateconcert().toString());
        holder.sceneView.setText(items.get(position).getScene());
        holder.groupView.setText(items.get(position).getGroupe());
        holder.heureView.setText(items.get(position).getHeure());
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
