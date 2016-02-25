package com.ehc.rovnostandroid.ui;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.ehc.rovnostandroid.R;
import com.ehc.rovnostandroid.adapter.SearchAdapter;

import java.util.ArrayList;

public class DashBoardActivity extends BaseActivity implements View.OnClickListener, SearchView.OnQueryTextListener {

    private DrawerLayout mDrawerLayout;
    private TextView consultations;
    private TextView payments;
    private SearchView searchView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private SearchAdapter mAdapter;
    private ArrayList<String> arr;
    private ArrayList<String> myDataset;
    private RelativeLayout recyclerViewLayout;
    private LinearLayout findDoctorLayout;
    private RelativeLayout dummyBackground;
    private LinearLayout gridLayout;
    private RelativeLayout symtomsLayout;
    private TextView findDoctor;
    private TextView ratings;
    private TextView myProfile;
    private TextView logout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        searchView = (SearchView) findViewById(R.id.search_id);
        applySearchViewProperties(searchView);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL_LIST));

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        arr = new ArrayList<>();
        arr.add("Cold");
        arr.add("Fever");
        arr.add("Cough");
        arr.add("Cougdfsdgdh");
        arr.add("jkfghf");
        arr.add("yrtuyyti");
        arr.add("lhk");
        arr.add("o;afdslkjfd;");
        arr.add("lafkal");
        arr.add("sdgdg");
        arr.add("sdfstgdg");
        arr.add("reytunbg");
        arr.add("etnbkyfbvy");
        arr.add("78645");
        arr.add("pkg5");
        myDataset = new ArrayList<>();
        mAdapter = new SearchAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        consultations = (TextView) findViewById(R.id.consultation);
        ratings = (TextView) findViewById(R.id.ratings);
        myProfile = (TextView) findViewById(R.id.my_profile);
        logout = (TextView) findViewById(R.id.logout);
        payments = (TextView) findViewById(R.id.payments);

        symtomsLayout = (RelativeLayout) findViewById(R.id.symptoms_layout);
        recyclerViewLayout = (RelativeLayout) findViewById(R.id.recycler_view_layout);
        findDoctorLayout = (LinearLayout) findViewById(R.id.find_doctor_layout);
        findDoctor = (TextView) findViewById(R.id.find_doctor);
        dummyBackground = (RelativeLayout) findViewById(R.id.dumy_background);
        gridLayout = (LinearLayout) findViewById(R.id.grid_layout);
        consultations.setOnClickListener(this);
        payments.setOnClickListener(this);
        ratings.setOnClickListener(this);
        logout.setOnClickListener(this);
        myProfile.setOnClickListener(this);
        findDoctor.setOnClickListener(this);
        gridLayout.setVisibility(View.VISIBLE);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notification_menu, menu);
        return true;
    }


    private void applySearchViewProperties(final SearchView searchView) {
        int searchPlateId = searchView.getContext().getResources()
                .getIdentifier("android:id/search_plate", null, null);
        View searchPlateView = searchView.findViewById(searchPlateId);

        if (searchPlateView != null) {
            searchPlateView.setBackgroundColor(Color.WHITE);
        }

        int id = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = (TextView) searchView.findViewById(id);

        if (textView != null) {
            textView.setTextColor(application.getResources().getColor(R.color.navigation_divider));
            textView.setHintTextColor(application.getResources().getColor(R.color.search_hint_color));
            textView.setFreezesText(true);
        }

        SearchManager searchManager = (SearchManager) context.getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (gridLayout.getVisibility() == View.VISIBLE)
                    mDrawerLayout.openDrawer(GravityCompat.START);
                else {
                    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
                    recyclerViewLayout.setVisibility(View.GONE);
                    gridLayout.setVisibility(View.VISIBLE);
                    findDoctorLayout.setVisibility(View.GONE);
                    dummyBackground.setVisibility(View.GONE);
                    searchView.setQuery("", false);
                    searchView.clearFocus();
                }
                return true;

            case R.id.notification:


        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
//                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_dash_board;
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()) {
            case R.id.consultation:
                Toast.makeText(getApplicationContext(), "consultation page", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                break;
            case R.id.payments:
                Toast.makeText(getApplicationContext(), "payments page", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                break;
            case R.id.find_doctor:
                 intent=new Intent(this,DoctorsActivity.class);
                startActivity(intent);
                break;
            case R.id.ratings:
               intent=new Intent(this,RatingActivity.class);
                startActivity(intent);
                mDrawerLayout.closeDrawers();
                break;
            case R.id.my_profile:
                intent=new Intent(this,MyProfile.class);
                startActivity(intent);
                mDrawerLayout.closeDrawers();
                break;
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (!newText.isEmpty()) {
            for (String data : arr) {
                if (data.toLowerCase().contains(newText.toLowerCase()))
                    myDataset.add(data);
            }
            if (gridLayout.getVisibility() == View.VISIBLE) {
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_navigate_before_white_36dp);
                recyclerViewLayout.setVisibility(View.VISIBLE);
                gridLayout.setVisibility(View.GONE);
                findDoctorLayout.setVisibility(View.VISIBLE);
                dummyBackground.setVisibility(View.VISIBLE);
            }
            mRecyclerView.setVisibility(View.VISIBLE);
            mAdapter.notifyDataSetChanged();
        } else {
            myDataset.clear();
//            mRecyclerView.setVisibility(View.INVISIBLE);
            mAdapter.notifyDataSetChanged();
        }
        return true;
    }
}
