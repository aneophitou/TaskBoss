package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;



public class SettingsActivity extends AppCompatActivity {

    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_fragment);
        }
    public static class NotifiFrag extends PreferenceFragment
    {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.notifi_frag);

        }

    }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.toolbar7);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}

    //Code to retain the project name & username
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void update(View view)
    {
        RadioButton r1 = findViewById(R.id.auto);
        RadioButton r2 = findViewById(R.id.man);

        if (r1.isChecked())
        {
            Toast.makeText(getApplicationContext(),"Automatic update is on",Toast.LENGTH_SHORT).show();
        }
        else if (r2.isChecked())
        {
            Toast.makeText(getApplicationContext(),"Automatic update is off",Toast.LENGTH_SHORT).show();
        }
    }


}
