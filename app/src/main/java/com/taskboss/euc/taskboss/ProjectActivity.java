package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

    }

    //code for add create project button
    public void createProject(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentView, new CreateProjectFragment()).commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

    //    //code for inflating the menu
//    @Override
//    public boolean onCreateOptionsMenu (Menu menu){
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.home, menu);
//        return true;
//    }
    //code for selecting items in the menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if (id==R.id.profile_settings){
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }
        else if (id==R.id.log_out){
            Toast.makeText(getApplicationContext(), "Logged Out",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ProjectActivity.this, LoginActivity.class));
            finish();
        }
        else if (id==R.id.nav_about)
        {
            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);
        }
        else if (id==R.id.action_help)
        {
            Intent i = new Intent(this, RateActivity.class);
            startActivity(i);
        }
        else if (id==R.id.nav_home)
        {
            Intent i = new Intent(this, ProjectActivity.class);
            startActivity(i);
        }
        else if (id==R.id.nav_tasks)
        {
            Intent i = new Intent(this, ProjectActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}
