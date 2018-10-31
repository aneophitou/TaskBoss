package com.taskboss.euc.taskboss;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class eventsFragment extends Fragment {

    String[] Events = {"Business Meeting","Latest Patch discussion","Shareholders Meeting"};
    String[] Places = {"Senate's Room","Conference Room A","Room 112"};
    String[] EventDate = {"7/11/2018","13/11/2018","8/11/2018"};
    String[] EventDescription = {"In our 4th business meeting we are going to discuss about the business benefits of" +
                                 " the new online store of our company.",
            "In the upcoming meeting the software patch team will present the fixes and updates that were made to the online store website" +
                    " before the final deployment of the website.","The senate of shareholders will discuss the change of the stock value of the company" +
            " after 1 month of the new systems deployment"};

    public eventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_events,container,false);

        ListView listView = (ListView) view.findViewById(R.id.ListView);

        ArrayAdapter<String> ListViewAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Events);

        listView.setAdapter(ListViewAdapter);

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(getActivity(),EventItem.class);
                intent.putExtra("EventTitle", Events[position]);
                intent.putExtra("EventPlace",Places[position]);
                intent.putExtra("EventDate", EventDate[position]);
                intent.putExtra("Description", EventDescription[position]);
                startActivity(intent);
            }
        });
        return view;
    }



}
