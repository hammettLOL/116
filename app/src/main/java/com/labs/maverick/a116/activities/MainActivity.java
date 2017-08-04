package com.labs.maverick.a116.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.labs.maverick.a116.R;
import com.labs.maverick.a116.fragments.ContactsFragment;
import com.labs.maverick.a116.fragments.MapFragment;

public class MainActivity extends AppCompatActivity {


    Fragment currentFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    currentFragment = new MapFragment();
                    changeFragment(currentFragment);
                    return true;
                case R.id.navigation_dashboard:
                    currentFragment = new ContactsFragment();
                    changeFragment(currentFragment);
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }

            return false;
        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        currentFragment = new MapFragment();
        changeFragment(currentFragment);
    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,fragment).commit();

    }

}
