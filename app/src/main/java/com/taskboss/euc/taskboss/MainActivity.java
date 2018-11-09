package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar8);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TaskBoss");

        Button createProj = findViewById(R.id.createProjectButton);
        createProj.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateProject.class));
            }
        });

        Button OurProj = findViewById(R.id.ourProjButton);
        Button HalkProj = findViewById(R.id.halkosButton);
        OurProj.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TaskActivity.class));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.nav_settings){
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);

            return true;
        } else if (id == R.id.log_out) {
            Toast.makeText(getApplicationContext(), "Logged Out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        } else if (id == R.id.nav_about) {
            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);
        } else if (id == R.id.action_help) {
            Intent i = new Intent(this, RateActivity.class);
            startActivity(i);
        }
        else if (id==R.id.nav_home)
        {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else if (id==R.id.nav_profile)
        {
            Intent i = new Intent(this, ProfileActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);

    }


}
