package com.taskboss.euc.taskboss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private static final String TAG = "LoginActivity";

    //    TextView mytv;
    //    Typeface myfont;
    Button LognInButton;
    EditText UsernameField;
    EditText PasswordField;
    //Intent MainActivityConnection = new Intent(LoginActivity.this,MainActivity.class);
    Handler setDelay;
    Runnable startDelay;

    public void SignIn(View view) {
        // the sign in function goes to SignIn Activity (not yet created)
        //Thread.sleep(1000);
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        //Log.d(TAG, "onCreate: started.");
        ImageView firstImage = findViewById(R.id.AppImage);
        setDelay = new Handler();

        int imageResourse = getResources().getIdentifier("@drawable/icons8_task_planning_100", null, this.getPackageName());
        firstImage.setImageResource(imageResourse);

//        mytv = (TextView)findViewById(R.id.TextView);
//        myfont = Typeface.createFromAsset(this.getAssets(),"fonts/Pacifico.ttf");
//        mytv.setTypeface(myfont);

        LognInButton = findViewById(R.id.button);
        UsernameField = findViewById(R.id.editTxtUsername);
        PasswordField = findViewById(R.id.editTxtPass);

        LognInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDelay =  new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                };

                if((UsernameField.getText().toString().equals("Giannis") && PasswordField.getText().toString().equals("GA1234")) ||
                  (UsernameField.getText().toString().equals("Andreas") && PasswordField.getText().toString().equals("AN1234")) ||
                  (UsernameField.getText().toString().equals("Ahmed") && PasswordField.getText().toString().equals("AA1234")) ||
                  (UsernameField.getText().toString().equals("Ola") && PasswordField.getText().toString().equals("OA1234"))) {

                    Toast.makeText(getApplicationContext(),"Signing In...",Toast.LENGTH_SHORT).show();
                    setDelay.postDelayed(startDelay, 1000);
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void ForgotPass(View v)
    {
        Intent intent = new Intent(getApplicationContext(), ForgotPassActivity.class);
        startActivity(intent);
    }
}