package com.example.apptonghop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar1;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_open,R.string.menu_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        Log.i("MENU_DRAWER_TAG0","Home item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_profile:
                        doOpenprofileActivity();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_list:
                        doOpenListActivity();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_sign:
                        doOpenLogoutActivity();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_listRv:
                        doOpenRvActivity();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });

    }
    private void doOpenprofileActivity(){
        Intent myIntent = new Intent(this, Profile.class);
        startActivity(myIntent);
    }
    private void doOpenListActivity(){
        Intent myIntent = new Intent(this, MainFood.class);
        startActivity(myIntent);
    }
    private void doOpenLogoutActivity(){
        Intent myIntent = new Intent(this, sign_up.class);
        startActivity(myIntent);
    }
    private void doOpenRvActivity(){
        Intent myIntent = new Intent(this, RecyclerViewUsers.class);
        startActivity(myIntent);
    }

}