package com.saidi.liveevents1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Billeterie extends AppCompatActivity {
    private Button button_reserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billeterie);
        button_reserver = (Button) findViewById(R.id.reserver);
        button_reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openReservation();
            }
        });
    }

    public void openReservation(){
        Uri uri = Uri.parse("https://www.ticketmaster.fr/fr/concert"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
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