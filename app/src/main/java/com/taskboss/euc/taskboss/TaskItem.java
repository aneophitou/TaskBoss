package com.taskboss.euc.taskboss;

import android.os.Bundle;
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
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

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

}
