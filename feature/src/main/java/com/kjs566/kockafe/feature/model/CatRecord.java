package com.kjs566.kockafe.feature.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public class CatRecord {
    private String id;
    private @StringRes int nameRes;
    private @StringRes int descriptionRes;
    private @DrawableRes int[] imagesRes;

    public CatRecord(String id, @StringRes int nameRes, @StringRes int descriptionRes, @DrawableRes int... imagesRes){
        this.id = id;
        this.nameRes = nameRes;
        this.descriptionRes = descriptionRes;
        this.imagesRes = imagesRes;
    }

    public String getId() {
        return id;
    }

    public int getNameRes() {
        return nameRes;
    }

    public int getDescriptionRes() {
        return descriptionRes;
    }

    public int[] getImagesRes() {
        return imagesRes;
    }
}
