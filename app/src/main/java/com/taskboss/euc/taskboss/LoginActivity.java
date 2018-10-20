package com.taskboss.euc.taskboss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

    public void SignIn(View view) throws InterruptedException {
        // the sign in function goes to SignIn Activity (not yet created)
        Toast.makeText(getApplicationContext(),"Loading...",Toast.LENGTH_SHORT).show();
        //Thread.sleep(1000);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        Log.d(TAG, "onCreate: started.");
        ImageView firstImage = (ImageView) findViewById(R.id.imageView1);

        int imageResourse = getResources().getIdentifier("@drawable/icons8_task_planning_100", null, this.getPackageName());
        firstImage.setImageResource(imageResourse);

//        mytv = (TextView)findViewById(R.id.TextView);
//        myfont = Typeface.createFromAsset(this.getAssets(),"fonts/Pacifico.ttf");
//        mytv.setTypeface(myfont);

        LognInButton = (Button)findViewById(R.id.button);
        UsernameField = (EditText)findViewById(R.id.editText);
        PasswordField = (EditText)findViewById(R.id.editText2);

        LognInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((UsernameField.getText().toString().equals("Giannis") && PasswordField.getText().toString().equals("GA1234")) ||
                  (UsernameField.getText().toString().equals("Andreas") && PasswordField.getText().toString().equals("AN1234")) ||
                  (UsernameField.getText().toString().equals("Ahmed") && PasswordField.getText().toString().equals("AA1234")) ||
                  (UsernameField.getText().toString().equals("Ola") && PasswordField.getText().toString().equals("OA1234"))) {

                    Toast.makeText(getApplicationContext(),"Signing In...",Toast.LENGTH_SHORT).show();
                    //startActivity(MainActivityConnection);
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}