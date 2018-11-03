package com.taskboss.euc.taskboss;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class tasksFragment extends Fragment {
ArrayList<String> TASKS = new ArrayList<String>(Arrays.asList("task 1", "task 2", "task3"));
ArrayList<String> DATES = new ArrayList<String>(Arrays.asList("31/10/2018", "05/11/2018","06/11/2018"));
ArrayList<String> TIMES = new ArrayList<String>(Arrays.asList("11:20", "10:30", "12:00"));
ArrayList<String> DESCRIPTIONS = new ArrayList<String>(Arrays.asList("Get candy for Trick or Treat", "Get Some Sleep", "Doctors Appointment"));
ArrayList<String> PRIORITIES = new ArrayList<String>(Arrays.asList("1","2","3"));
    ArrayAdapter<String> adapter;

    public tasksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("added",("test3"));

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tasks, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.taskList);

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, TASKS) {

            //code to change the color of the text in the list
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(getResources().getColor(R.color.TextColor));

                return view;
            }
        };
        listView.setAdapter(adapter);
        Bundle bundle = this.getArguments();
        if (bundle!= null) {
            TASKS.add(bundle.getString("title"));
            adapter.notifyDataSetChanged();

            Log.e("added",bundle.getString("title"));
        }
        //code to handle clicks of the items in the list
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(getActivity(),TaskItem.class);
                intent.putExtra("title", TASKS.get(position));
                intent.putExtra("date", DATES.get(position));
                intent.putExtra("description", DESCRIPTIONS.get(position));
                intent.putExtra("time", TIMES.get(position));
                intent.putExtra("priority", PRIORITIES.get(position));

                startActivity(intent);
            }
        });


        return rootView;
    }

    public void putArguments(Bundle args){
        Log.e("added",args.getString("test1"));
        TASKS.add(args.getString("test1"));

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }


}
