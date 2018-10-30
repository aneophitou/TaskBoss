package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText UsernameField;
    EditText PasswordField;
    EditText PasswordCheck;
    Button CreateButton;
    String Username = "";
    String Password = "";
    String PasswordVerify = "";

    Handler setDelay;
    Runnable startDelay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setDelay = new Handler();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        CreateButton = (Button)findViewById(R.id.button1);
        UsernameField = (EditText)findViewById(R.id.editText1);
        PasswordField = (EditText)findViewById(R.id.editText2);
        PasswordCheck = (EditText)findViewById(R.id.editText3);

        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDelay =  new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    }
                };

                Username = UsernameField.getText().toString();
                Password = PasswordField.getText().toString();
                PasswordVerify = PasswordCheck.getText().toString();

                if(Password.equals(PasswordVerify) && !Username.equals("") && (!Password.equals("") && !PasswordVerify.equals(""))) {

                    Toast.makeText(getApplicationContext(),"Creating Account...",Toast.LENGTH_SHORT).show();
                    setDelay.postDelayed(startDelay, 1000);
                }
                else if(!Password.equals(PasswordVerify) && !Username.equals("")){ // Check if Password = PasswordVerify && Username = ""
                    Toast.makeText(getApplicationContext(), "The passwords does not match...",Toast.LENGTH_SHORT).show();
                }
                else if(Username.equals("") && !Password.equals("") && !PasswordVerify.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "You have not entered a username...",Toast.LENGTH_SHORT).show();
                }
                else if(!Username.equals("") && (Password.equals("") || PasswordVerify.equals("")))
                {
                    Toast.makeText(getApplicationContext(), "You did not fill all password fields...",Toast.LENGTH_SHORT).show();
                }
                else if(Username.equals("") && Password.equals("") && PasswordVerify.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please fill the form...",Toast.LENGTH_SHORT).show();
                }
                else if(Username.equals("") && ((Password.equals("") && !PasswordVerify.equals("") || (!Password.equals("") && PasswordVerify.equals("")))))
                {
                    Toast.makeText(getApplicationContext(), "Enter username & password again...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
