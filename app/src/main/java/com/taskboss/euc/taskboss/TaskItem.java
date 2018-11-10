package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskItem extends AppCompatActivity {
String[] MEMBERS = {"Andreas", "Giannis", "Ahmed", "Ola","Assign this task"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_item);
        DisablePriority(false);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Currently Viewing Task");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Currently Viewing Task");

        EditText ActionDoneKeyboard = findViewById(R.id.txtDescription);

        ActionDoneKeyboard.setImeOptions(EditorInfo.IME_ACTION_DONE);
        ActionDoneKeyboard.setRawInputType(InputType.TYPE_CLASS_TEXT);

        String title = getIntent().getStringExtra("title");
        String dateString = getIntent().getStringExtra("date");
        TextView txtTitle = this.findViewById(R.id.txtTaskTitle);
        Switch PrioritySwitch = findViewById(R.id.SwitchEditPriority);
        txtTitle.setText(title);
        TextView txtDate = this.findViewById(R.id.txtDate);
        Date date = null;

        PrioritySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {
                    DisablePriority(true);
                }
                else
                {
                    DisablePriority(false);
                }
            }
        });


        try {
            date = new SimpleDateFormat("dd/MM/YYYY").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = new SimpleDateFormat("dd MM YYYY").format(date);
        txtDate.setText(formattedDate);

        String timeString = getIntent().getStringExtra("time");
        TextView txtTime = this.findViewById(R.id.txtTime);

            SimpleDateFormat time = new SimpleDateFormat("hh:mm");
        try{
            Date dateTime = time.parse(timeString);

            txtTime.setText(time.format(dateTime));
        }catch(ParseException e){
            e.printStackTrace();
        }

        RadioGroup radioGroup = findViewById(R.id.rgPriority);
        String priority = getIntent().getStringExtra("priority");
        if(priority != null) {
            if (priority.equals("1")) {
                radioGroup.check(R.id.rbLow);
            } else if (priority.equals("2")) {
                radioGroup.check(R.id.rbMedium);
            } else if (priority.equals("3")) {
                radioGroup.check(R.id.rbHigh);
            }
        }


        TextView txtDescription = this.findViewById(R.id.txtDescription);
        txtDescription.setText(getIntent().getStringExtra("description"));

        Spinner spinner = findViewById(R.id.spinnerAssign);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, MEMBERS){
          @Override
          public View getView(int position, View convertView, ViewGroup parent){
              View view = super.getView(position, convertView, parent);
              if(position ==getCount()){
                  ((TextView) view.findViewById(android.R.id.text1)).setText("");
                  ((TextView) view.findViewById(android.R.id.text1)).setHint(getItem(getCount()));

              }
              return view;
          }
          @Override
            public int getCount(){
              return super.getCount()-1;
          }
        };
        spinner.setAdapter(spinnerAdapter);

        String assignedTo = getIntent().getStringExtra("assignedTo");
        spinner.setSelection(spinnerAdapter.getCount());
        for(int i = 0; i<MEMBERS.length -1; i++){
            if (MEMBERS[i].equals(assignedTo)){
                spinner.setSelection(spinnerAdapter.getPosition(assignedTo));
            }
        }

    }


    public void closeTask(View v){
        Toast.makeText(getApplicationContext(),"Task Closed",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(TaskItem.this,TaskActivity.class );
        startActivity(intent);
    }

    public void DisablePriority(boolean switcher)
    {
        RadioButton rbLow = findViewById(R.id.rbLow);
        RadioButton rbMedium = findViewById(R.id.rbMedium);
        RadioButton rbHigh= findViewById(R.id.rbHigh);

        rbLow.setEnabled(switcher);
        rbLow.setFocusableInTouchMode(switcher);
        rbLow.setFocusable(switcher);
        rbLow.setClickable(switcher);

        rbMedium.setEnabled(switcher);
        rbMedium.setFocusableInTouchMode(switcher);
        rbMedium.setFocusable(switcher);
        rbMedium.setClickable(switcher);

        rbHigh.setEnabled(switcher);
        rbHigh.setFocusableInTouchMode(switcher);
        rbHigh.setFocusable(switcher);
        rbHigh.setClickable(switcher);

        if(!switcher)
        {
            rbLow.setTextColor(Color.parseColor("#9D9D9D"));
            rbMedium.setTextColor(Color.parseColor("#9D9D9D"));
            rbHigh.setTextColor(Color.parseColor("#9D9D9D"));
        }
        else
        {
            rbLow.setTextColor(Color.parseColor("#000000"));
            rbMedium.setTextColor(Color.parseColor("#000000"));
            rbHigh.setTextColor(Color.parseColor("#000000"));
        }
    }

}
