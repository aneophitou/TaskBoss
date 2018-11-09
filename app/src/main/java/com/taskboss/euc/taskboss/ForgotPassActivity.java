package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassActivity extends AppCompatActivity {

    EditText EmailField;
    EditText UsernameField;
    EditText AnswerField;
    Button SubmitButton;
    RadioButton RadioButton1;
    RadioButton RadioButton2;
    RadioGroup radioGroupItems;
    TextView Question;
    String Email = "";
    String Username = "";
    String Answer = "";

    Handler setDelay;
    Runnable startDelay;
    String ActivityName = "FORGOT_PASS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setDelay = new Handler();

        EmailField = findViewById(R.id.editTxtEmail);
        UsernameField = findViewById(R.id.txtDescription);
        AnswerField = findViewById(R.id.editTxtEnterAnswer);
        RadioButton1 = findViewById(R.id.radioButton1);
        RadioButton2 = findViewById(R.id.radioButton2);
        SubmitButton = findViewById(R.id.btnSendAttedance);
        Question = findViewById(R.id.txtQuestion);
        radioGroupItems = findViewById(R.id.radioGroup);

        // radio button listener to display the appropriate question
        radioGroupItems.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = radioGroupItems.findViewById(checkedId);
                int index = radioGroupItems.indexOfChild(radioButton);

                switch (index) {
                    case 0: // first button
                        Question.setText("From which country you are from?");
                        break;
                    case 1: // second button
                        Question.setText("When is your birthday?");
                        break;
                }
            }
        });

        // submission button listener to check if the user credentials are correct
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDelay = new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(ForgotPassActivity.this, SignUpActivity.class);
                        intent.putExtra("USERNAME_KEY",Username);
                        intent.putExtra("ACTIVITY_NAME",ActivityName);
                        startActivity(intent);
                        finish();
                    }
                };

                Email = EmailField.getText().toString();
                Username = UsernameField.getText().toString();
                Answer = AnswerField.getText().toString();

                if (Email.equals("Andreas@euc.ac.cy") && Username.equals("Andreas") && (RadioButton1.isChecked() && Answer.equals("Cyprus") || (RadioButton2.isChecked() && Answer.equals("")))) {
                    Toast.makeText(getApplicationContext(), "Recovering Andreas's email", Toast.LENGTH_SHORT).show();
                    setDelay.postDelayed(startDelay, 1000);
                } else if (Email.equals("Ahmed@euc.ac.cy") && Username.equals("Ahmed") && (RadioButton1.isChecked() && Answer.equals("Egypt") || (RadioButton2.isChecked() && Answer.equals("")))) {
                    Toast.makeText(getApplicationContext(), "Recovering Ahmed's email", Toast.LENGTH_SHORT).show();
                    setDelay.postDelayed(startDelay, 1000);
                } else if (Email.equals("Giannis@euc.ac.cy") && Username.equals("Giannis") && (RadioButton1.isChecked() && Answer.equals("Greece") || (RadioButton2.isChecked() && Answer.equals("")))) {
                    Toast.makeText(getApplicationContext(), "Recovering Giannis's email", Toast.LENGTH_SHORT).show();
                    setDelay.postDelayed(startDelay, 1000);
                } else if (Email.equals("Ola@euc.ac.cy") && Username.equals("Ola") && (RadioButton1.isChecked() && Answer.equals("Nigeria") || (RadioButton2.isChecked() && Answer.equals("")))) {
                    Toast.makeText(getApplicationContext(), "Recovering Ola's email", Toast.LENGTH_SHORT).show();
                    setDelay.postDelayed(startDelay, 1000);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Recovering Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
