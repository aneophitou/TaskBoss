package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

public class create_event extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // change the keyboard bottom-right-corner key to "DONE" mode for all EditTexts
        EditText ActionDoneKeyboard1 = findViewById(R.id.txtDescription);
        EditText ActionDoneKeyboard2 = findViewById(R.id.txtEventName);
        EditText ActionDoneKeyboard3 = findViewById(R.id.txtTimeIn);
        EditText ActionDoneKeyboard4 = findViewById(R.id.txtTimeOut);
        EditText ActionDoneKeyboard5 = findViewById(R.id.txtDate);

        ActionDoneKeyboard1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        ActionDoneKeyboard1.setRawInputType(InputType.TYPE_CLASS_TEXT);

        ActionDoneKeyboard2.setImeOptions(EditorInfo.IME_ACTION_DONE);
        ActionDoneKeyboard2.setRawInputType(InputType.TYPE_CLASS_TEXT);

        ActionDoneKeyboard3.setImeOptions(EditorInfo.IME_ACTION_DONE);
        ActionDoneKeyboard3.setRawInputType(InputType.TYPE_CLASS_TEXT);

        ActionDoneKeyboard4.setImeOptions(EditorInfo.IME_ACTION_DONE);
        ActionDoneKeyboard4.setRawInputType(InputType.TYPE_CLASS_TEXT);

        ActionDoneKeyboard5.setImeOptions(EditorInfo.IME_ACTION_DONE);
        ActionDoneKeyboard5.setRawInputType(InputType.TYPE_CLASS_TEXT);
    }

    public void SubmitEvent(View view)
    {
        Toast.makeText(this.getApplicationContext(),"Submiting Event...",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(create_event.this, MainActivity.class));
    }

}
