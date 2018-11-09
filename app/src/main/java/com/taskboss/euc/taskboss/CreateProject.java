package com.taskboss.euc.taskboss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateProject extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);

        Toolbar toolbar = findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner comboBox = findViewById(R.id.comboBox1);

        Button btnAdd = findViewById(R.id.addProj);
        btnAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                EditText projName = findViewById(R.id.projectNameTxt);
                EditText stDate = findViewById(R.id.startDate);
                EditText enDate = findViewById(R.id.endDate);

                Intent intent = new Intent();
                String projectName = projName.getText().toString();
                String startDate = stDate.getText().toString();
                String endDate = enDate.getText().toString();

                intent.putExtra("Project Name", projectName);
                intent.putExtra("Start Date", startDate);
                intent.putExtra("Due", endDate);

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(CreateProject.this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
