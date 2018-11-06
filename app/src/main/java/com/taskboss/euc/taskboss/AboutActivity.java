package com.taskboss.euc.taskboss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

    }
    public void loadUrl(View v)
    {
        WebView w = findViewById(R.id.web);
        w.setWebViewClient(new WebViewClient());

        Button f = findViewById(R.id.facebook);
        Button t = findViewById(R.id.twitter);
        Button r = findViewById(R.id.reddit);

        if (f.getId() == v.getId())
        {
            w.loadUrl(("https://www.facebook.com"));
        }
        else if (t.getId() == v.getId())
        {
            w.loadUrl(("https://www.twitter.com"));
        }
        else if (r.getId() == v.getId())
        {
            w.loadUrl(("https://www.reddit.com"));
        }


    }
}
