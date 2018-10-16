package com.taskboss.euc.taskboss;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();
    private Context context;

    TabAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position){
        return fragmentList.get(position);
    }

    //function to add a tab
    public void addFragment (Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position){
        return fragmentTitleList.get(position);
    }

    @Override
    public int getCount(){
        return fragmentList.size();
    }

    public View getTabView(int position){
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_tab, null);
        return view;
    }

    public View getSelectedTabView(int position){
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_tab, null);
        return view;
    }
}
