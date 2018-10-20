package com.taskboss.euc.taskboss;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

public class tasksFragment extends Fragment {
String[] TASKS = {"task 1", "task 2"};


    public tasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_tasks, container, false);


        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, TASKS) ;;
        ListView listView = (ListView) getView().findViewById(R.id.taskList);
        listView.setAdapter(adapter);


    }

}
