package com.dmhashanmd.slpd.CivilianDashBord;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.dmhashanmd.slpd.CivilianDashBord.main.SectionsPagerAdapter;
import com.dmhashanmd.slpd.databinding.ActivityCivilianDashBord2Binding;

public class CivilianDashBordActivity extends AppCompatActivity {

    private ActivityCivilianDashBord2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCivilianDashBord2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }
}