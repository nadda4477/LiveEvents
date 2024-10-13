package com.saidi.liveevents1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements  OnMapReadyCallback{
    private Button button_billeterie;

    public void openFacebook(){
        Uri uri = Uri.parse("https://www.facebook.com/Ticketmaster/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void openInstagram(){
        Uri uri = Uri.parse("https://www.instagram.com/ticketmaster/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void openTiktok(){
        Uri uri = Uri.parse("https://www.tiktok.com/@ticketmaster?lang=fr"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void openTwitter(){
        Uri uri = Uri.parse("https://x.com/Ticketmaster"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("group1", "scene1", "7-Jun-2013", "20", R.drawable.img1))    ;
        items.add(new Item("group2", "scene2", "7-Jun-2013", "20", R.drawable.img2));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
        button_billeterie = (Button) findViewById(R.id.billeterie_button);
        button_billeterie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBilleterie();
            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);


        ImageView Facebook = (ImageView) findViewById(R.id.facebook);
        Facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebook();
            }
        });

        ImageView Instagram = (ImageView) findViewById(R.id.instagram);
        Instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagram();
            }
        });

        ImageView Tiktok = (ImageView) findViewById(R.id.tiktok);
        Tiktok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTiktok();
            }
        });

        ImageView Twitter = (ImageView) findViewById(R.id.twitter);
        Twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTwitter();
            }
        });

    }
    public void openBilleterie(){
        Intent intent = new Intent(this,Billeterie.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.4233438, -122.0728817), -0.5f));
        LatLng seine_musicale = new LatLng(48.976240, 2.179640);
        googleMap.addMarker(new MarkerOptions()
                .position(seine_musicale)
                .title("Seine Musicale"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(seine_musicale));

        LatLng scene_barbe = new LatLng(48.888920, 2.353400);
        googleMap.addMarker(new MarkerOptions()
                .position(scene_barbe)
                .title("LA SCENE BARBES"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(scene_barbe));

        LatLng celebrity_centre = new LatLng(48.950920, 2.462170);
        googleMap.addMarker(new MarkerOptions()
                .position(celebrity_centre)
                .title("Théâtre Celebrity Centre"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(celebrity_centre));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Switching on the item id of the menu item
        switch (item.getItemId()) {
            case R.id.Billetterie:
                Intent B_activity = new Intent(this,Billeterie.class);
                this.startActivity(B_activity);
                return true;
            case R.id.accueil:
                Intent M_activity = new Intent(this,MainActivity.class);
                this.startActivity(M_activity);
                return true;
            case R.id.Partenaire:
                Intent P_activity = new Intent(this,Partenaire.class);
                this.startActivity(P_activity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}