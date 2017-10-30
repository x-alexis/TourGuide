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
public class MonumentFragment extends Fragment {

    // Required empty public constructor
    public MonumentFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Creating an array of monuments
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.string.title_monuments_1, R.string.description_monuments_1, R.drawable.monument_1_lenin_small, R.drawable.monument_1_lenin_large, new LatLng(55.159633, 61.402590)));
        places.add(new Place(R.string.title_monuments_2, R.string.description_monuments_2, R.drawable.monument_2_kurchatov_small, R.drawable.monument_2_kurchatov_large, new LatLng(55.15931986, 61.362777)));
        places.add(new Place(R.string.title_monuments_3, R.string.description_monuments_3, R.drawable.monument_3_synam_small, R.drawable.monument_3_synam_large, new LatLng(55.16336194, 61.40966356)));
        places.add(new Place(R.string.title_monuments_4, R.string.description_monuments_4, R.drawable.monument_4_belocheh_small, R.drawable.monument_4_belocheh_large, new LatLng(55.14111, 61.41444)));
        places.add(new Place(R.string.title_monuments_5, R.string.description_monuments_5, R.drawable.monument_5_mavzolei_small, R.drawable.monument_5_mavzolei_large, new LatLng(55.160280, 61.391110)));
        places.add(new Place(R.string.title_monuments_6, R.string.description_monuments_6, R.drawable.monument_6_skorb_small, R.drawable.monument_6_skorb_large, new LatLng(55.118278, 61.363194)));
        places.add(new Place(R.string.title_monuments_7, R.string.description_monuments_7, R.drawable.monument_7_parovoz_small, R.drawable.monument_7_parovoz_large, new LatLng(55.153160, 61.407560)));
        places.add(new Place(R.string.title_monuments_8, R.string.description_monuments_8, R.drawable.monument_8_orlenok_small, R.drawable.monument_8_orlenok_large, new LatLng(55.160472, 61.392925)));
        places.add(new Place(R.string.title_monuments_9, R.string.description_monuments_9, R.drawable.monument_9_pravoporyadok_small, R.drawable.monument_9_pravoporyadok_large, new LatLng(55.168611, 61.395833)));
        places.add(new Place(R.string.title_monuments_10, R.string.description_monuments_10, R.drawable.monument_10_newway_small, R.drawable.monument_10_newway_large, new LatLng(55.147220, 61.416940)));

        //Inserting arraylist information to listView
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places, 0);
        ListView listView = rootView.findViewById(R.id.listview);
        listView.setAdapter(placeAdapter);

        return rootView;
    }

}
