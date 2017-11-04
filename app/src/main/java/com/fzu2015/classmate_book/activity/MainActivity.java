package com.fzu2015.classmate_book.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fzu2015.classmate_book.R;
import com.fzu2015.classmate_book.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MainAdapter adapter;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initViews(){
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        list = new ArrayList<>();
        //adapter = new MainAdapter(getSupportFragmentManager(), list);
        //InitMainActivityUtil.init(viewPager, tabLayout, adapter, list);
        //StatusBarUtil.setStatusBar(this);
    }

}
