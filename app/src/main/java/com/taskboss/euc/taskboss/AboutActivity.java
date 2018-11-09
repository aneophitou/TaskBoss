package com.taskboss.euc.taskboss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void loadUrl(View v)
    {
        WebView w = findViewById(R.id.web);
        w.setWebViewClient(new WebViewClient());

        if (R.id.facabook == v.getId())
        {
            w.loadUrl(("https://www.facebook.com"));
        }
        else if (R.id.twitter == v.getId())
        {
            w.loadUrl(("https://www.twitter.com"));
        }
        else if (R.id.reddit == v.getId())
        {
            w.loadUrl(("https://www.reddit.com"));
        }
        else if (R.id.ourwebsite == v.getId())
        {
            Toast.makeText(this, "Soryy, out website is under maintenance", Toast.LENGTH_LONG).show();
        }


    }
}
