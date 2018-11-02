package com.taskboss.euc.taskboss;


import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class tasksFragment extends Fragment {
String[] TASKS = {"task 1", "task 2", "task3"};
String[] DATES = {"31/10/2018", "05/11/2018","06/11/2018"};
String[] TIMES= {"11:20", "10:30", "12:00"};
String[] DESCRIPTIONS = {"Get candy for Trick or Treat", "Get Some Sleep", "Doctors Appointment"};
String[] PRIORITIES = {"1","2","3"};



    public tasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_tasks, container, false);
            ListView listView = (ListView) rootView.findViewById(R.id.taskList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, TASKS) {

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

        //code to handle clicks of the items in the list
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(getActivity(),TaskItem.class);
                intent.putExtra("title", TASKS[position]);
                intent.putExtra("date", DATES[position]);
                intent.putExtra("description", DESCRIPTIONS[position]);
                intent.putExtra("time", TIMES[position]);
                intent.putExtra("priority", PRIORITIES[position]);


                startActivity(intent);
            }
        });

        String string = getArguments().getString("test1");


        return rootView;
    }





    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }


}
