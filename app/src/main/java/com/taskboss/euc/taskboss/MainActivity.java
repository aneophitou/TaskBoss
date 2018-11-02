package com.taskboss.euc.taskboss;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{
    PageAdapter mPageAdapter;
    ViewPager mViewPager;
    TabLayout tabLayout;


    public class PageAdapter extends FragmentStatePagerAdapter{
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();


        public PageAdapter(FragmentManager fm){
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
        public CharSequence getPageTitle(int position){
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
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.pageview);
        tabLayout = findViewById(R.id.tabs);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        mPageAdapter = new PageAdapter(getSupportFragmentManager());
        mPageAdapter.addFragment(new tasksFragment(), "Assigned Tasks");
        mPageAdapter.addFragment(new allTasksFragment(), "All Tasks");
        mPageAdapter.addFragment(new eventsFragment(), "Events");
        mViewPager.setAdapter(mPageAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);



    }

    //code for inflating the menu
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }
    //code for selecting items in the menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if (id==R.id.action_settings){
            return true;
        }
        if (id==R.id.log_out){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    //code for add task button
    public void createTask(View view){
        Intent intent = new Intent(MainActivity.this,create_task.class );
        startActivity(intent);

    }

    //code for Bottom navigation view
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new ProjectFragment();
                            break;
                        case R.id.nav_notification:
                            selectedFragment = new NotificationFragment();
                            break;
                        case R.id.nav_assign:
                            selectedFragment = new AssignedFragment();
                            break;
                        case R.id.nav_calendar:
                            selectedFragment = new CalendarFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.pageview, selectedFragment).commit();

                    return true;
                }
            };


}
