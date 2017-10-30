package com.trottdevelopment.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.model.LatLng;

/**
 * Detailed information about each separate place.
 */

public class PlaceDetailActivity extends AppCompatActivity {

    private Bundle mIncomeBundle;
    private LatLng mLocation;
    private int mFragmentId;

    // override method for passing bundle to parent activity
    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        Intent intent = super.getSupportParentActivityIntent();
        intent.putExtra("fragmentid", mFragmentId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        //Adding "Up" button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Find views
        ImageView image = (ImageView) findViewById(R.id.detailimage);
        TextView title = (TextView) findViewById(R.id.detailtitle);
        TextView description = (TextView) findViewById(R.id.detaildescription);
        FrameLayout iconLocation = (FrameLayout) findViewById(R.id.iconlocation);

        //Getting bundle and LatLng
        mIncomeBundle = getIntent().getParcelableExtra("bundle");
        mLocation = mIncomeBundle.getParcelable("location");
        mFragmentId = mIncomeBundle.getInt("fragmentid");

        //Setting information to views
        image.setImageResource(mIncomeBundle.getInt("image"));
        title.setText(mIncomeBundle.getInt("title"));
        description.setText(mIncomeBundle.getInt("description"));


        //Adding onClickListener to follow map
        iconLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceMapActivity.class);
                //Adding extras to bundle
                Bundle outcomeBundle = new Bundle();
                outcomeBundle.putParcelable("location", mLocation);
                outcomeBundle.putInt("title", mIncomeBundle.getInt("title"));
                //Adding bundle to intent
                intent.putExtra("bundle", outcomeBundle);
                view.getContext().startActivity(intent);
            }
        });
    }


}
