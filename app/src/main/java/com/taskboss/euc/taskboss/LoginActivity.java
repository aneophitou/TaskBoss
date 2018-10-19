package com.taskboss.euc.taskboss;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class LoginActivity extends Activity {

    private static final String TAG = "LoginActivity";

//    TextView mytv;
//    Typeface myfont;

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
    }
}