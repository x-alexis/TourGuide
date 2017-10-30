package com.trottdevelopment.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TheaterFragment extends Fragment {


    public TheaterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);
        
        // Creating an array of theaters
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.string.title_theaters_1, R.string.description_theaters_1, R.drawable.theater_1_chtz_small, R.drawable.theater_1_chtz_large, new LatLng(55.160900, 61.450400)));
        places.add(new Place(R.string.title_theaters_2, R.string.description_theaters_2, R.drawable.theater_2_opera_small, R.drawable.theater_2_opera_large, new LatLng(55.166500, 61.402100)));
        places.add(new Place(R.string.title_theaters_3, R.string.description_theaters_3, R.drawable.theater_3_drama_small, R.drawable.theater_3_drama_large, new LatLng(55.156036, 61.402814)));
        places.add(new Place(R.string.title_theaters_4, R.string.description_theaters_4, R.drawable.theater_4_maneken_small, R.drawable.theater_4_maneken_large, new LatLng(55.158100, 61.409300)));
        places.add(new Place(R.string.title_theaters_5, R.string.description_theaters_5, R.drawable.theater_5_tuz_small, R.drawable.theater_5_tuz_large, new LatLng(55.159167, 61.400556)));
        places.add(new Place(R.string.title_theaters_6, R.string.description_theaters_6, R.drawable.theater_6_kukol_small, R.drawable.theater_6_kukol_large, new LatLng(55.180560, 61.398610)));

        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places,1);
        ListView listView = rootView.findViewById(R.id.listview);
        listView.setAdapter(placeAdapter);
        
        return rootView;
    }

}
