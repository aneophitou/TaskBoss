package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ForgotPassActivity extends AppCompatActivity {

    EditText EmailField;
    EditText UsernameField;
    EditText AnswerField;
    Button SubmitButton;
    RadioButton RadioButton1;
    RadioButton RadioButton2;
    String Email = "";
    String Username = "";
    String Answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EmailField = findViewById(R.id.editTxtEmail);
        UsernameField = findViewById(R.id.editTxtUsername);
        AnswerField = findViewById(R.id.editTxtEnterAnswer);
        RadioButton1 = findViewById(R.id.radioButton1);
        RadioButton2 = findViewById(R.id.radioButton2);
        SubmitButton = findViewById(R.id.button1);

        Email = EmailField.getText().toString();
        Username = UsernameField.getText().toString();
        Answer = AnswerField.getText().toString();

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Email.equals("Andreas@euc.ac.cy") && Username.equals("Andreas") && (RadioButton1.isChecked() && Answer.equals("Cyprus") || (RadioButton2.isChecked() && Answer.equals("")))) {
                    startActivity(new Intent(ForgotPassActivity.this,SignUpActivity.class));
                    Toast.makeText(getApplicationContext(), "Recovering Account...", Toast.LENGTH_SHORT).show();
                } else if (Email.equals("Ahmed@euc.ac.cy") && Username.equals("Ahmed") && (RadioButton1.isChecked() && Answer.equals("Egypt") || (RadioButton2.isChecked() && Answer.equals("")))) {
                    startActivity(new Intent(ForgotPassActivity.this,SignUpActivity.class));
                    Toast.makeText(getApplicationContext(), "Recovering Account...", Toast.LENGTH_SHORT).show();
                } else if (Email.equals("Giannis@euc.ac.cy") && Username.equals("Giannis") && (RadioButton1.isChecked() && Answer.equals("Greece") || (RadioButton2.isChecked() && Answer.equals("")))) {
                    startActivity(new Intent(ForgotPassActivity.this,SignUpActivity.class));
                    Toast.makeText(getApplicationContext(), "Recovering Account...", Toast.LENGTH_SHORT).show();
                } else if (Email.equals("Ola@euc.ac.cy") && Username.equals("Ola") && (RadioButton1.isChecked() && Answer.equals("Nigeria") || (RadioButton2.isChecked() && Answer.equals("")))) {
                    startActivity(new Intent(ForgotPassActivity.this,SignUpActivity.class));
                    Toast.makeText(getApplicationContext(), "Recovering Account...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
