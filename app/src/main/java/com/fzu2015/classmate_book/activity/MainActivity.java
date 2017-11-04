package com.fzu2015.classmate_book.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fzu2015.classmate_book.R;
import com.fzu2015.classmate_book.adapter.MainAdapter;
import com.fzu2015.classmate_book.fragment.MemberFragment;
import com.fzu2015.classmate_book.fragment.PersonalFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String[] TAB_NAME = {"通讯录","个人"};
    private static final int[] TAB_ICON_1 = {R.drawable.album_abc_spinner_white,R.drawable.album_ic_add_photo_white};
    private static final int[] TAB_ICON_2 = {R.drawable.album_abc_spinner_white,R.drawable.album_ic_add_photo_white};
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MainAdapter adapter;
    private List<Fragment> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        list = new ArrayList<>();
        adapter = new MainAdapter(getSupportFragmentManager(), list);
        //InitMainActivityUtil.init(viewPager, tabLayout, adapter, list);
        //StatusBarUtil.setStatusBar(this);
        ////初始化主页视图
        MemberFragment fragment1 = new MemberFragment();
        PersonalFragment fragment2 = new PersonalFragment();
        list.add(fragment1);
        list.add(fragment2);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(viewPager);
        for(int i=0;i<list.size();i++){
            tabLayout.getTabAt(i).setText(TAB_NAME[i]);
            tabLayout.getTabAt(i).setIcon(TAB_ICON_1[i]);
        }

        //监听处理

        tabLayout.getTabAt(0).setIcon(TAB_ICON_2[0]);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    for(int i=0;i<list.size();i++){
                        tabLayout.getTabAt(i).setIcon(TAB_ICON_1[i]);
                    }
                    tab.setIcon(TAB_ICON_2[tab.getPosition()]);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }

}
