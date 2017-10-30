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
public class ParklandFragment extends Fragment {


    public ParklandFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Creating an array of parklands
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.string.title_parklands_1, R.string.description_parklands_1, R.drawable.parkland_1_aloe_small, R.drawable.parkland_1_aloe_large, new LatLng(55.163610, 61.391110)));
        places.add(new Place(R.string.title_parklands_2, R.string.description_parklands_2, R.drawable.parkland_2_revolution_small, R.drawable.parkland_2_revolution_large, new LatLng(55.159089, 61.402497)));
        places.add(new Place(R.string.title_parklands_3, R.string.description_parklands_3, R.drawable.parkland_3_pavshih_small, R.drawable.parkland_3_pavshih_large, new LatLng(55.169720, 61.414440)));
        places.add(new Place(R.string.title_parklands_4, R.string.description_parklands_4, R.drawable.parkland_4_komsa_small, R.drawable.parkland_4_komsa_large, new LatLng(55.160000, 61.441110)));
        places.add(new Place(R.string.title_parklands_5, R.string.description_parklands_5, R.drawable.parkland_5_kirovka_small, R.drawable.parkland_5_kirovka_large, new LatLng(55.166670, 61.400361)));
        places.add(new Place(R.string.title_parklands_6, R.string.description_parklands_6, R.drawable.parkland_6_yaroslav_small, R.drawable.parkland_6_yaroslav_large, new LatLng(55.167000, 61.403000)));
        places.add(new Place(R.string.title_parklands_7, R.string.description_parklands_7, R.drawable.parkland_7_pkio_small, R.drawable.parkland_7_pkio_large, new LatLng(55.163132, 61.372134)));

        //Inserting arraylist information to listView
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places, 2);
        ListView listView = rootView.findViewById(R.id.listview);
        listView.setAdapter(placeAdapter);

        return rootView;
    }

}
