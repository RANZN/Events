package com.ranzan.events;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements CommunicationListener {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EventDetailsFragment fragment = new EventDetailsFragment();
        fragmentTransaction.add(R.id.container, fragment, "event").commit();
    }

    @Override
    public void launchTimeAndDate(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TimeAndDateFragment fragment = new TimeAndDateFragment();
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, fragment, "DateNTime").addToBackStack("").commit();
    }

    @Override
    public void launchPrice(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PriceDetailsFragment fragment = new PriceDetailsFragment();
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, fragment, "Price").addToBackStack("").commit();
    }
}