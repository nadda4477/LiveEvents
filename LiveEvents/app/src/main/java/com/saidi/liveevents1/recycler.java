package com.saidi.liveevents1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class recycler extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView groupView, sceneView, dateConcertView, heureView;

    public recycler(@NonNull View itemView) {
        super(itemView);
        groupView = itemView.findViewById(R.id.Groupe);
        sceneView = itemView.findViewById(R.id.Scene);
        dateConcertView = itemView.findViewById(R.id.dateconcert);
        heureView = itemView.findViewById(R.id.heure);
        imageView = itemView.findViewById(R.id.imageview);



    }
}
