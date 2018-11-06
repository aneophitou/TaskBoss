package com.taskboss.euc.taskboss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //


    }

    //code for Bottom navigation view
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {


                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch(item.getItemId()){
                        case R.id.nav_home:
                            startActivity(new Intent(SettingsActivity.this, ProjectActivity.class));

                            break;
                        case R.id.nav_notification:

                            break;
                        case R.id.nav_tasks:
                            startActivity(new Intent(SettingsActivity.this, MainActivity.class));

                            break;
                        case R.id.nav_settings:
                            startActivity(new Intent(SettingsActivity.this, SettingsActivity.class));

                            break;
                    }

                    return true;
                }
            };
}
