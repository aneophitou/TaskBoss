package com.taskboss.euc.taskboss;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                EditText title = (EditText) findViewById(R.id.txtTaskName);
                Log.e("test", title.getText().toString());
                Bundle args = new Bundle();
                String taskName = title.getText().toString();
                args.putString("test1", taskName);
                tasksFragment fragment = new tasksFragment();
                fragment.putArguments(args);
                Log.e("test", "teeere");
                setResult(Activity.RESULT_OK);
                Log.e("test Onclick Button", "I run when you create a task!");
                finish();
            }
        });


    }
}
