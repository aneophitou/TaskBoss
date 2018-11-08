package com.taskboss.euc.taskboss;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class create_task extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String assignedTo;
    String priority = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Add a new task!");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        //Code for radio group to set the priority
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rgPriority);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbLow:
                        priority = "1";
                        break;
                    case R.id.rbMedium:
                        priority = "2";
                        break;
                    case R.id.rbHigh:
                        priority = "3";
                        break;

                }
            }
        });


        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                EditText title = findViewById(R.id.txtTaskName);
                EditText description = findViewById(R.id.txtDescription);
                EditText date = findViewById(R.id.txtDate);
                EditText time = findViewById(R.id.txtTime);

                Intent intent = new Intent();
                String taskName = title.getText().toString();

                intent.putExtra("title", taskName);
                intent.putExtra("description", description.getText().toString());
                intent.putExtra("date", date.getText().toString());
                intent.putExtra("time", time.getText().toString());
                intent.putExtra("priority", priority);
                intent.putExtra("assignedTo",assignedTo);

                Toast.makeText(getApplicationContext(),"Task Created!",Toast.LENGTH_LONG).show();
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        assignedTo = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
