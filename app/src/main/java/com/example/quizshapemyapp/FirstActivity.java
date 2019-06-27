package com.example.quizshapemyapp;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.Toast;

import com.example.quizshapemyapp.R;
import com.google.android.material.navigation.NavigationView;


import java.util.ArrayList;
import java.util.Arrays;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
getSupportActionBar().setTitle("Home");
        //Initializing NavigationView
        navigationView = (NavigationView)
                findViewById(R.id.navigation_view);

        //Default Fragment
       MainFragment mainFragment = new MainFragment();
       FragmentTransaction homeFragmentTransaction
                = getSupportFragmentManager().beginTransaction();
        homeFragmentTransaction.replace(R.id.frame,mainFragment);
        homeFragmentTransaction.commit();

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {

                    // This method will trigger on item Click of navigation menu
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        //Checking if the item is in checked state or not, if not make it in checked state
                        if(menuItem.isChecked()) menuItem.setChecked(false);
                        else menuItem.setChecked(true);

                        //Closing drawer on item click
                        drawerLayout.closeDrawers();

                        //Check to see which item was being clicked and perform appropriate action
                        switch (menuItem.getItemId()){

                            case R.id.home:
                                MainFragment mainFragment = new MainFragment();
                                FragmentTransaction homeFragmentTransaction
                                        = getSupportFragmentManager().beginTransaction();
                                homeFragmentTransaction.replace(R.id.frame,mainFragment);
                                homeFragmentTransaction.commit();

                                return true;

                            case R.id.a1:


                                return true;

                            case R.id.a2:

                                return true;

                            case R.id.a3:

                                return true;

                            case R.id.a4:

                                return true;

                            case R.id.a5:

                                return true;

                            case R.id.a6:

                                return true;

                            case R.id.a7:

                                return true;

                            case R.id.a8:

                                return true;

                            case R.id.a9:

                                return true;


                            default:
                                Toast.makeText(getApplicationContext(),"Somethings Wrong",Toast.LENGTH_SHORT).show();
                                return true;

                        }
                    }
                });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.mnc);
        ActionBarDrawerToggle actionBarDrawerToggle
                = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

}