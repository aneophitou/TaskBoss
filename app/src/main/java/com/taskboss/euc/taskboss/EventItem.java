package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EventItem extends AppCompatActivity {

    String Title;
    String Place;
    String Date;
    String Description;
    RadioGroup RadioGroup;
    RadioButton RadioButton1;
    RadioButton RadioButton2;
    RadioButton RadioButton3;
    Button SendAttendance;

    Handler setDelay;
    Runnable startDelay;

    public void CloseEvent(View v)
    {
        Toast.makeText(getApplicationContext(),"Closing Event...",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EventItem.this, TaskActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Title = getIntent().getStringExtra("EventTitle");
        Place = getIntent().getStringExtra("EventPlace");
        Date = getIntent().getStringExtra("EventDate");
        Description = getIntent().getStringExtra("Description");

        TextView TitleText = this.findViewById(R.id.Title);
        TextView PlaceText = this.findViewById(R.id.Place);
        TextView DateText = this.findViewById(R.id.txtDate);
        TextView DescriptionText = this.findViewById(R.id.txtDescription);

        TitleText.setText(Title);
        PlaceText.setText(Place);
        DateText.setText(Date);
        DescriptionText.setText(Description);

        RadioButton1 = findViewById(R.id.RadioButton1);
        RadioButton2 = findViewById(R.id.RadioButton2);
        RadioButton3 = findViewById(R.id.RadioButton3);
        RadioGroup = findViewById(R.id.RadioGroup);
        SendAttendance = findViewById(R.id.btnSendAttedance);
        setDelay = new Handler();

        SendAttendance.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(RadioButton1.isChecked() || RadioButton2.isChecked() || RadioButton3.isChecked())
                {
                    if (RadioButton1.isChecked())
                    {
                        DisableRadioButton();
                        Toast.makeText(getApplicationContext(), "Thank you for attending!", Toast.LENGTH_SHORT).show();
                    }
                    else if(RadioButton2.isChecked())
                    {
                        DisableRadioButton();
                        Toast.makeText(getApplicationContext(), "Hopefully you can make it!", Toast.LENGTH_SHORT).show();
                    }
                    else if(RadioButton3.isChecked())
                    {
                        DisableRadioButton();
                        Toast.makeText(getApplicationContext(), "We are sorry to hear that!", Toast.LENGTH_SHORT).show();
                    }

                    RadioGroup.setBackgroundResource(R.drawable.greying_field);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Choose participation first...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void DisableRadioButton()
    {
        RadioButton1.setEnabled(false);
        RadioButton1.setFocusableInTouchMode(false);
        RadioButton1.setFocusable(false);
        RadioButton1.setClickable(false);
        RadioButton1.setTextColor(Color.parseColor("#9D9D9D"));

        RadioButton2.setEnabled(false);
        RadioButton2.setFocusableInTouchMode(false);
        RadioButton2.setFocusable(false);
        RadioButton2.setClickable(false);
        RadioButton2.setTextColor(Color.parseColor("#9D9D9D"));

        RadioButton3.setEnabled(false);
        RadioButton3.setFocusableInTouchMode(false);
        RadioButton3.setFocusable(false);
        RadioButton3.setClickable(false);
        RadioButton3.setTextColor(Color.parseColor("#9D9D9D"));
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

}
