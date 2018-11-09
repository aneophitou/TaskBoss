package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class create_event extends AppCompatActivity {
    EditText ActionDoneKeyboard1;
    CheckBox InviteAll;
    CheckBox CheckBox1;
    CheckBox CheckBox2;
    CheckBox CheckBox3;
    CheckBox CheckBox4;
    String Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // change the keyboard bottom-right-corner key to "DONE" mode for the last required EditText (the description)
        ActionDoneKeyboard1 = findViewById(R.id.txtDescription);

        ActionDoneKeyboard1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        ActionDoneKeyboard1.setRawInputType(InputType.TYPE_CLASS_TEXT);

        InviteAll = findViewById(R.id.CheckBoxInviteAll);
        CheckBox1 = findViewById(R.id.CheckBoxMember1);
        CheckBox2 = findViewById(R.id.CheckBoxMember2);
        CheckBox3 = findViewById(R.id.CheckBoxMember3);
        CheckBox4 = findViewById(R.id.CheckBoxMember4);

        InviteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InviteAll.isChecked()) {
                    CheckBox1.setChecked(true);
                    CheckBox2.setChecked(true);
                    CheckBox3.setChecked(true);
                    CheckBox4.setChecked(true);
                }
                else
                {
                    CheckBox1.setChecked(false);
                    CheckBox2.setChecked(false);
                    CheckBox3.setChecked(false);
                    CheckBox4.setChecked(false);
                }
            }
            });

    }

    public void SubmitEvent(View view)
    {
        InviteMembers();
        Toast.makeText(this.getApplicationContext(),Message,Toast.LENGTH_SHORT).show();
        startActivity(new Intent(create_event.this, TaskActivity.class));
    }

    public String InviteMembers()
    {
        if(CheckBox4.isChecked())
        {
            Message = "Andreas was invited...";
        }
        if(CheckBox3.isChecked())
        {
            Message = "Ahmed was invited...";
        }
        if(CheckBox2.isChecked())
        {
            Message = "Giannis was invited...";
        }
        if(CheckBox1.isChecked())
        {
            Message = "Ola was invited...";
        }
        if(CheckBox4.isChecked() && CheckBox3.isChecked())
        {
            Message = "Andreas and Ahmed were invited...";
        }
        if(CheckBox3.isChecked() && CheckBox2.isChecked())
        {
            Message = "Ahmed and Giannis were invited...";
        }
        if(CheckBox4.isChecked() && CheckBox1.isChecked())
        {
            Message = "Andreas and Ola were invited...";
        }
        if(CheckBox4.isChecked() && CheckBox3.isChecked())
        {
            Message = "Andreas and Ahmed were invited...";
        }
        if(CheckBox2.isChecked() && CheckBox1.isChecked())
        {
            Message = "Giannis and Ola were invited...";
        }
        if(CheckBox4.isChecked() && CheckBox2.isChecked())
        {
            Message = "Andreas and Giannis were invited...";
        }
        if(CheckBox3.isChecked() && CheckBox1.isChecked())
        {
            Message = "Ahmed and Ola were invited...";
        }
        if(CheckBox4.isChecked() && CheckBox3.isChecked() && CheckBox2.isChecked())
        {
            Message = "Andreas, Ahmed and Giannis were invited...";
        }
        if(CheckBox4.isChecked() && CheckBox3.isChecked() && CheckBox1.isChecked())
        {
            Message = "Andreas, Ahmed and Ola were invited...";
        }
        if(CheckBox3.isChecked() && CheckBox2.isChecked() && CheckBox1.isChecked())
        {
            Message = "Ahmed,Giannis and Ola were invited...";
        }
        if(CheckBox4.isChecked() && CheckBox3.isChecked() && CheckBox2.isChecked())
        {
            Message = "Andreas, Giannis and Ola were invited...";
        }
        if(CheckBox1.isChecked() && CheckBox2.isChecked() && CheckBox3.isChecked() && CheckBox4.isChecked())
        {
            Message = "All members were invited...";
        }
        if(!CheckBox1.isChecked() && !CheckBox2.isChecked() && !CheckBox3.isChecked() && !CheckBox4.isChecked())
        {
            Message = "No members was invited...";
        }

        return (Message);
    }
}
