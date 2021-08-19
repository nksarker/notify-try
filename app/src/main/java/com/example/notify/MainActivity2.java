package com.example.notify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {


    private ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar = getSupportActionBar();
        //loadFragment(new StoreFragment());
        Configuration config = getResources().getConfiguration();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new home_fragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.home:
                    Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                  //  getSupportFragmentManager().beginTransaction().replace(R.id.container,new home_fragment()).commit();
                    return true;
                case R.id.calendar:
                    Toast.makeText(getApplicationContext(),"Calendar",Toast.LENGTH_SHORT).show();
                  //  getSupportFragmentManager().beginTransaction().replace(R.id.container,new calendar()).commit();
                    return true;
                case R.id.notification:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new notification_fragment()).commit();
                    //   Toast.makeText(getApplicationContext(),"Notification",Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new user_profile_fragment()).commit();
                  //  Toast.makeText(getApplicationContext(),"Profile",Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };





}