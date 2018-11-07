package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }
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
    public void share(View v)
    {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
