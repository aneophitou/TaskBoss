package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventItem extends AppCompatActivity {

    String Title;
    String Place;
    String Date;
    String Description;
    RadioButton RadioButton1;
    RadioButton RadioButton2;
    RadioButton RadioButton3;
    Button SendAttendance;

    Handler setDelay;
    Runnable startDelay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EditText ActionDoneKeyboard = findViewById(R.id.txtDescription);

        ActionDoneKeyboard.setImeOptions(EditorInfo.IME_ACTION_DONE);
        ActionDoneKeyboard.setRawInputType(InputType.TYPE_CLASS_TEXT);

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
        SendAttendance = findViewById(R.id.btnSendAttedance);
        setDelay = new Handler();

        SendAttendance.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startDelay = new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(EventItem.this, TaskActivity.class);
                        startActivity(intent);
                        finish();
                    }
                };

                if (RadioButton1.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "Thank you for attending!", Toast.LENGTH_SHORT).show();
                    setDelay.postDelayed(startDelay, 1000);
                }
                else if(RadioButton2.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "Hopefully you can make it!", Toast.LENGTH_SHORT).show();
                    setDelay.postDelayed(startDelay, 1000);
                }
                else if(RadioButton3.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "We are sorry to hear that!", Toast.LENGTH_SHORT).show();
                    setDelay.postDelayed(startDelay, 1000);
                }
            }
        });
    }

}
