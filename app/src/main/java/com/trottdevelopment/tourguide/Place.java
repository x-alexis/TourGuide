package com.trottdevelopment.tourguide;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Albert on 06.10.2017.
 * Handles information about each separate place
 */

public class Place {
    private int mTitleResourceId;
    private int mDescriptionResourceId;
    private int mSmallImageResourceId;
    private int mLargeImageResourceId;
    private LatLng mLatLng;

    public Place(int mTitleResourceId, int mDescriptionResourceId, int mSmallImageResourceId, int mLargeImageResourceId, LatLng mLatLng) {
        this.mTitleResourceId = mTitleResourceId;
        this.mDescriptionResourceId = mDescriptionResourceId;
        this.mSmallImageResourceId = mSmallImageResourceId;
        this.mLargeImageResourceId = mLargeImageResourceId;
        this.mLatLng = mLatLng;
    }

    public int getmTitleResourceId() {
        return mTitleResourceId;
    }

    public int getmDescriptionResourceId() {
        return mDescriptionResourceId;
    }

    public int getmSmallImageResourceId() {
        return mSmallImageResourceId;
    }

    public LatLng getmLatLng() {
        return mLatLng;
    }

    public int getmLargeImageResourceId() {
        return mLargeImageResourceId;
    }
}
