package com.example.lenovo.bbqu.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.lenovo.bbqu.R;
import com.example.lenovo.bbqu.fragment.fragment1;
import com.example.lenovo.bbqu.fragment.fragment3;
import com.example.lenovo.bbqu.fragment.fragment4;
import com.example.lenovo.bbqu.fragment.fragment2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private android.support.v4.view.ViewPager main_viewPager;
    private com.example.lenovo.bbqu.fragment.fragment1 fragment1;
    private com.example.lenovo.bbqu.fragment.fragment2 fragment2;
    private com.example.lenovo.bbqu.fragment.fragment3 fragment3;
    private com.example.lenovo.bbqu.fragment.fragment4 fragment4;

    private RadioGroup main_tab_RadioGroup;
    private ArrayList<Fragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_viewPager = (android.support.v4.view.ViewPager) findViewById(R.id.main_viewPager);


        main_tab_RadioGroup = (RadioGroup) findViewById(R.id.main_tab_RadioGroup);


        fragment1 = new fragment1();
        fragment2 = new fragment2();
        fragment3 = new fragment3();
        fragment4 = new fragment4();

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);

        main_tab_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int current = 0;
                switch (checkedId) {
                    case R.id.radio_1:
                        current = 0;
                        break;
                    case R.id.radio_2:
                        current = 1;
                        break;
                    case R.id.radio_3:
                        current = 2;
                        break;
                    case R.id.radio_4:
                        current = 3;
                        break;

                }
                if (main_viewPager.getCurrentItem() != current) {
                    main_viewPager.setCurrentItem(current);
                }

            }
        });

        main_viewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {
            public void onPageSelected(int arg0) {
                int current = main_viewPager.getCurrentItem();
                switch (current) {
                    case 0:
                        main_tab_RadioGroup.check(R.id.radio_1);
                        break;
                    case 1:
                        main_tab_RadioGroup.check(R.id.radio_2);
                        break;
                    case 2:
                        main_tab_RadioGroup.check(R.id.radio_3);
                        break;
                    case 3:
                        main_tab_RadioGroup.check(R.id.radio_4);
                        break;

                }
            }


            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int index) {
            }
        });

        main_viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
    }
    public class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }
}
