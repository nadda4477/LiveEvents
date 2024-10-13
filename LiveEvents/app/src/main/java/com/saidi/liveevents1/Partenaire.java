package com.saidi.liveevents1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class Partenaire extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partenaires_layout);
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
