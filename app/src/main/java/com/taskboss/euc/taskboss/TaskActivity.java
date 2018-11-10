package com.taskboss.euc.taskboss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;


public class TaskActivity extends AppCompatActivity {
    PageAdapter mPageAdapter;
    ViewPager mViewPager;
    TabLayout tabLayout;

    String currentUser;
    String projectName;
    Bundle user;

    FloatingActionButton fab;
    public class PageAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();


        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        //this code is for retrieving the fragment with a bundle of parameters
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        mViewPager = findViewById(R.id.pageview);
        tabLayout = findViewById(R.id.tabs);
        Toolbar toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.MainActionButton);

        if (savedInstanceState != null){

            projectName = savedInstanceState.getString("Project Name");
            currentUser = savedInstanceState.getString("username");
        }else{

            projectName = getIntent().getStringExtra("Project Name");
            currentUser = getIntent().getStringExtra("username");
        }
        toolbar.setTitle(projectName);
        setSupportActionBar(toolbar);


        mPageAdapter = new PageAdapter(getSupportFragmentManager());
        mPageAdapter.addFragment(new tasksFragment(), "Assigned Tasks");
        mPageAdapter.addFragment(new allTasksFragment(), "All Tasks");
        mPageAdapter.addFragment(new eventsFragment(), "Events");
        mViewPager.setAdapter(mPageAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        user = new Bundle();
        user.putString("username", currentUser);
        user.putString("Project Name", projectName);

        // code to switch the top-left button to "ADD TASK" or "ADD EVENT" mode
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {

                    fab.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(TaskActivity.this, create_task.class);
                            intent.putExtras(user);
                            startActivity(intent);

                        }
                    });
                } else if (tab.getPosition() == 1) {

                    fab.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(TaskActivity.this, create_task.class);
                            intent.putExtras(user);
                            startActivity(intent);
                        }
                    });
                } else if (tab.getPosition() == 2) {

                    fab.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(TaskActivity.this, create_event.class);
                            intent.putExtras(user);
                            startActivity(intent);
                        }
                    });
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    //code for inflating the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

    //code for selecting items in the menu
    @Override

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if (id==R.id.nav_settings){
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);

            return true;
        } else if (id == R.id.log_out) {
            Toast.makeText(getApplicationContext(), "Logged Out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        } else if (id == R.id.nav_about) {
            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);
        } else if (id == R.id.action_help) {
            Intent i = new Intent(this, RateActivity.class);
            startActivity(i);
        }
        else if (id==R.id.nav_home)
        {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else if (id==R.id.nav_profile)
        {
            Intent i = new Intent(this, ProfileActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    //code for add task button
    public void createTask(View view) {
        Intent intent = new Intent(TaskActivity.this, create_task.class);

        startActivityForResult(intent, 10001);

    }

    //Code to receive the result from the newly generated activity and then reload the fragment
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 10001) && (resultCode == Activity.RESULT_OK)) {

            Bundle bundle = new Bundle();
            String putTitle = data.getExtras().getString("title");
            bundle.putString("title", putTitle);
            bundle.putString("description", data.getExtras().getString("description"));
            bundle.putString("date", data.getExtras().getString("date"));
            bundle.putString("time", data.getExtras().getString("time"));
            bundle.putString("priority", data.getExtras().getString("priority"));
            bundle.putString("assignedTo", data.getExtras().getString("assignedTo"));


            Fragment tfrag = new allTasksFragment();
            tfrag.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().replace(R.id.allTasksFragment, tfrag).commit();
            if(currentUser.equals(data.getExtras().getString("assignedTo"))){
                Fragment tfrag2 = new tasksFragment();
                tfrag2.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.taskFragmentFrame, tfrag2).commit();
            }

        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("username", currentUser);
        savedInstanceState.putString("Project Name", projectName);


        super.onSaveInstanceState(savedInstanceState);
    }


}
