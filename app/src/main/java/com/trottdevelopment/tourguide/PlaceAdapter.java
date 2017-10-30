package com.trottdevelopment.tourguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Albert on 06.10.2017.
 * Serve to establish each place in place_item.xml
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    // Handles fragment ID to know on which position we should return from
    // PlaceDetailActivity to MainActivity
    private int mFragmentId;

    public PlaceAdapter(Activity context, ArrayList<Place> places, int fragmentId) {
        super(context, 0, places);
        mFragmentId = fragmentId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        View listPlacesView = convertView;

        //First launching listPlacesView
        if (listPlacesView == null) {
            listPlacesView = LayoutInflater.from(getContext()).inflate(
                    R.layout.place_item, parent, false);
        }

        final Place place = getItem(position);

        //Finding views
        ImageView smallImage = listPlacesView.findViewById(R.id.smallimage);
        TextView title = listPlacesView.findViewById(R.id.title);
        TextView description = listPlacesView.findViewById(R.id.description);

        //Setting views
        smallImage.setImageResource(place.getmSmallImageResourceId());
        title.setText(place.getmTitleResourceId());
        description.setText(place.getmDescriptionResourceId());

        //Setting onClickListener
        listPlacesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PlaceDetailActivity.class);
                //Adding extras to bundle
                Bundle bundle = new Bundle();
                bundle.putParcelable("location", place.getmLatLng());
                bundle.putInt("title", place.getmTitleResourceId());
                bundle.putInt("description", place.getmDescriptionResourceId());
                bundle.putInt("image", place.getmLargeImageResourceId());
                bundle.putInt("fragmentid", mFragmentId);
                //Adding bundle to intent
                intent.putExtra("bundle", bundle);
                getContext().startActivity(intent);
            }
        });

        return listPlacesView;
    }
}
