package com.taskboss.euc.taskboss;

import android.content.Intent;
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
ArrayList<String> ASSIGNMENTS = new ArrayList<String>(Arrays.asList("Andreas", "Andreas", "Andreas"));


    ArrayAdapter<String> adapter;

    public tasksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tasks, container, false);
        ListView listView = rootView.findViewById(R.id.taskList);

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, TASKS) {

            //code to change the color of the text in the list
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = view.findViewById(android.R.id.text1);
                textView.setTextColor(getResources().getColor(R.color.TextColor));

                return view;
            }
        };

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
                intent.putExtra("assignedTo", ASSIGNMENTS.get(position));
                startActivity(intent);
            }
        });

        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = this.getArguments();
        if (bundle!= null ) {
            TASKS.add(bundle.getString("title"));
            DATES.add(bundle.getString("date"));
            TIMES.add(bundle.getString("time"));
            DESCRIPTIONS.add(bundle.getString("description"));
            PRIORITIES.add(bundle.getString("priority"));
            ASSIGNMENTS.add(bundle.getString("assignedTo"));

            adapter.notifyDataSetChanged();


        }
    }


}
