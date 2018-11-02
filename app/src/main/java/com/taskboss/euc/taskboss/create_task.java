package com.taskboss.euc.taskboss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class create_task extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Add a new task!");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        //ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,R.layout.@values/strings,AssignToIndividualList);

    }

    public void submit(View view){
        TextView title = (TextView) view.findViewById(R.id.txtTaskName);

        Bundle args = new Bundle();
        String taskName = title.getText().toString();
        args.putString("test1", taskName);
        tasksFragment fragment = new tasksFragment();
        fragment.setArguments(args);
    }


}
