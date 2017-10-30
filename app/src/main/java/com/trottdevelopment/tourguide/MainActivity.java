package com.trottdevelopment.tourguide;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // Handles fragment ID to select from which fragment we should restart
    // MainActivity if user comes from PlaceDetailView
    private int mSelectedFragmentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting title to distinguish from App name title
        getSupportActionBar().setTitle(R.string.title_activity_main);

        //Getting fragment ID from PlaceDetailView if we returns from there
        mSelectedFragmentId = getIntent().getIntExtra("fragmentid", 0);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        //Helps make custom view for viewPager in activity_main
        CategoryPagerAdapter categoryPagerAdapter = new CategoryPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(categoryPagerAdapter);
        //Setting selected page fragment
        viewPager.setCurrentItem(mSelectedFragmentId);

        //Assign tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    //This method allows to make custom menu in our Toolbar to
    //add information icon
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    //This method handles user response (clicking on action button)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_info:
                Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}
