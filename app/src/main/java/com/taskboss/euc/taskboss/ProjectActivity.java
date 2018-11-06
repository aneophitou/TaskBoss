package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class ProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        //bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    //code for add create project button
    public void createProject(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentView, new CreateProjectFragment()).commit();


    }


    //code for Bottom navigation view
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {


                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch(item.getItemId()){
                        case R.id.nav_home:
                            startActivity(new Intent(ProjectActivity.this, ProjectActivity.class));

                            break;
                        case R.id.nav_notification:

                            break;
                        case R.id.nav_tasks:
                            startActivity(new Intent(ProjectActivity.this, MainActivity.class));

                            break;
                        case R.id.nav_settings:
                            startActivity(new Intent(ProjectActivity.this, SettingsActivity.class));

                            break;
                    }

                    return true;
                }
            };
}
