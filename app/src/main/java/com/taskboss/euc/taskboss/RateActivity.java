package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class RateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        Toolbar toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


<<<<<<< HEAD
<<<<<<< HEAD
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(RateActivity.this, TaskActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
=======

>>>>>>> 0642d4af281746a9cd87b2f860d0821a1712b349
=======

>>>>>>> 0642d4af281746a9cd87b2f860d0821a1712b349

    public void rateMessage(View v)
    {
        RatingBar r = findViewById(R.id.ratingBar);
        TextView t = findViewById(R.id.rateText);

        if (r.getRating() > 3)
        {
            t.setText("We are happy that you like our app!\nEnjoy it..");
        }
        else
        {
            t.setText("We will try to get better..");
        }
    }
    public void getFeedback(View view)
    {
        EditText e = (EditText) findViewById(R.id.editText);
        TextView v1 = (TextView) findViewById(R.id.feedback_message);
        TextView v2 = (TextView) findViewById(R.id.feedback_message2);
        String s = e.getText().toString();
        v1.setText(s);
        v1.setBackgroundColor(Color.parseColor("#47a04c"));
        v2.setBackgroundColor(Color.parseColor("#ffffff"));
        v2.setText("Thanks for your feedback\nWe will reply as soon as we get your message");

    }
    public void share(View v)
    {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
