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
public class MuseumFragment extends Fragment {


    public MuseumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);
        
        // Creating an array of museums
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.string.title_museums_1, R.string.description_museums_1, R.drawable.museum_1_izo_small, R.drawable.museum_1_izo_large, new LatLng(55.159492, 61.404088)));
        places.add(new Place(R.string.title_museums_2, R.string.description_museums_2, R.drawable.museum_2_kraeved_small, R.drawable.museum_2_kraeved_large, new LatLng(55.168330, 61.397780)));
        places.add(new Place(R.string.title_museums_3, R.string.description_museums_3, R.drawable.museum_3_yujd_small, R.drawable.museum_3_yujd_large, new LatLng(55.135469,  61.412531)));

        //Inserting arraylist information to listView
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places,3);
        ListView listView = rootView.findViewById(R.id.listview);
        listView.setAdapter(placeAdapter);
        
        return rootView;
    }

}
