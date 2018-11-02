package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskItem extends AppCompatActivity {
String[] MEMBERS = {"Andreas", "Giannis", "Ahmed", "Ola","Assign this task"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_item);

        EditText ActionDoneKeyboard = (EditText) findViewById(R.id.txtDescription);

        ActionDoneKeyboard.setImeOptions(EditorInfo.IME_ACTION_DONE);
        ActionDoneKeyboard.setRawInputType(InputType.TYPE_CLASS_TEXT);

        String title = getIntent().getStringExtra("title");
        String dateString = getIntent().getStringExtra("date");
        TextView txtTitle = (TextView) this.findViewById(R.id.txtTaskTitle);
        txtTitle.setText(title);
        TextView txtDate = (TextView) this.findViewById(R.id.txtDate);
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/YYYY").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = new SimpleDateFormat("dd MM YYYY").format(date);
        txtDate.setText(formattedDate);

        String timeString = getIntent().getStringExtra("time");
        TextView txtTime = (TextView) this.findViewById(R.id.txtTime);

            SimpleDateFormat time = new SimpleDateFormat("hh:mm");
        try{
            Date dateTime = time.parse(timeString);

            txtTime.setText(time.format(dateTime));
        }catch(ParseException e){
            e.printStackTrace();
        }

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rgPriority);
        String priority = getIntent().getStringExtra("priority");
        if(priority.equals("1")){
            radioGroup.check(R.id.rbLow);
        }else if(priority.equals("2")){
            radioGroup.check(R.id.rbMedium);
        }else if(priority.equals("3")){
            radioGroup.check(R.id.rbHigh);
        }



        TextView txtDescription = (TextView) this.findViewById(R.id.txtDescription);
        txtDescription.setText(getIntent().getStringExtra("description"));

        Spinner spinner = (Spinner) findViewById(R.id.spinnerAssign);
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
        spinner.setSelection(spinnerAdapter.getCount());



    }


    public void closeTask(View v){
        Toast.makeText(getApplicationContext(),"Task Closed",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(TaskItem.this,MainActivity.class );
        startActivity(intent);
    }


}
