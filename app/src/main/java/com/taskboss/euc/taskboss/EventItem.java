package com.taskboss.euc.taskboss;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class EventItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText ActionDoneKeyboard = findViewById(R.id.DescriptionText);

        ActionDoneKeyboard.setImeOptions(EditorInfo.IME_ACTION_DONE);
        ActionDoneKeyboard.setRawInputType(InputType.TYPE_CLASS_TEXT);

        String Title = getIntent().getStringExtra("EventTitle");
        String Place = getIntent().getStringExtra("EventPlace");
        String Date = getIntent().getStringExtra("EventDate");
        String Description = getIntent().getStringExtra("Description");

        TextView TitleText = this.findViewById(R.id.Title);
        TextView PlaceText = this.findViewById(R.id.Place);
        TextView DateText = this.findViewById(R.id.editTxtPass);
        TextView DescriptionText = this.findViewById(R.id.DescriptionText);

        TitleText.setText(Title);
        PlaceText.setText(Place);
        DateText.setText(Date);
        DescriptionText.setText(Description);

        FloatingActionButton fab = findViewById(R.id.AddEvent);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "** Note: This button will probably be removed **", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
