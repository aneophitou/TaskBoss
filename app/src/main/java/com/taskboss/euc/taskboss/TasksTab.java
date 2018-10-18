package com.taskboss.euc.taskboss;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TasksTab.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TasksTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TasksTab extends Fragment {

    public TasksTab() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TasksTab newInstance(String param1, String param2) {
        TasksTab fragment = new TasksTab();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks_tab, container, false);
        //TextView textV = (TextView)  view.findViewById(R.id.txtTest);

        ListView lstView = (ListView) view.findViewById(R.id.taskList);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(view.getContext(), "thisis a test", Toast.LENGTH_LONG).show();
            }
        });


        String[] items={"1","2","3","4","5"};
        ListViewAdapter adapter = new ListViewAdapter(view.getContext(), R.layout.list_item, R.id.txt,items);
        lstView.setAdapter(adapter);
        //Toast.makeText(getActivity(), textV.getText(), Toast.LENGTH_LONG).show();
        return view;
    }

    public void listClick(View view){
        Button bt=(Button) view;
        Toast.makeText(view.getContext(), "Button "+bt.getText().toString(),Toast.LENGTH_LONG).show();
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
