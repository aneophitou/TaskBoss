package com.taskboss.euc.taskboss;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class eventsFragment extends Fragment {

    ArrayList<String> Events = new ArrayList<String>(Arrays.asList("Business Meeting", "Latest Patch discussion", "Shareholders Meeting"));
    ArrayList<String> Places = new ArrayList<String>(Arrays.asList("Senate's Room EUC",
            "6, Diogenis Str., 2404 Engomi, \n" +
                    "P.O. Box: 22006, 1516 Nicosia-Cyprus\",\"Room 112 EUC", "Room 112 EUC"));
    ArrayList<String> EventDate = new ArrayList<String>(Arrays.asList("11:30 a.m 7/11/2018","12:45 p.m 13/11/2018","17:00 p.m 8/11/2018"));
    ArrayList<String> EventDescription = new ArrayList<String>(Arrays.asList("In our 4th business meeting we are going to discuss about the business benefits of" +
            " the new online store of our company.",
            "In the upcoming meeting the software patch team will present the fixes and updates that were made to the online store website" +
            " before the final deployment of the website.",
            "The senate of shareholders will discuss the change of the stock value of the company" +
                    " after 1 month of the new systems deployment."
            ));

    public eventsFragment() {
        // Required empty public constructor
    }

    public void CloseEvent(View v)
    {
        String RemoveTitle = getActivity().getIntent().getStringExtra("EventTitle");
        String RemovePlace = getActivity().getIntent().getStringExtra("EventPlace");
        String RemoveDate = getActivity().getIntent().getStringExtra("EventDate");
        String RemoveDescription = getActivity().getIntent().getStringExtra("Description");

        Events.remove(RemoveTitle);
        Places.remove(RemovePlace);
        EventDate.remove(RemoveDate);
        EventDescription.remove(RemoveDescription);

        Toast.makeText(getActivity().getApplicationContext(),"Closing Event...",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(eventsFragment.this.getActivity(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_events,container,false);

        ListView listView = (ListView) view.findViewById(R.id.ListView);

        //Button fab = (Button) Button.findViewById(R.id.AddEvent);
        //fab.setOnClickListener(CloseEvent());

        ArrayAdapter<String> ListViewAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Events);

        listView.setAdapter(ListViewAdapter);

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(getActivity(),EventItem.class);
                intent.putExtra("EventTitle", Events.get(position));
                intent.putExtra("EventPlace",Places.get(position));
                intent.putExtra("EventDate", EventDate.get(position));
                intent.putExtra("Description", EventDescription.get(position));
                startActivity(intent);
            }
        });
        return view;
    }



}
