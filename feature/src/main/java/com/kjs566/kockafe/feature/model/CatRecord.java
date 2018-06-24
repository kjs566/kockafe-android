package com.kjs566.kockafe.feature.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public class CatRecord {
    private String id;
    private @StringRes int nameRes;
    private @StringRes int descriptionRes;
    private String[] imageUris;
    private @DrawableRes int detailBackgroundRes;

    public CatRecord(String id, @StringRes int nameRes, @StringRes int descriptionRes, @DrawableRes int detailBackgroundRes, String... imageUris){
        this.id = id;
        this.nameRes = nameRes;
        this.descriptionRes = descriptionRes;
        this.imageUris = imageUris;
        this.detailBackgroundRes = detailBackgroundRes;
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

    public String[] getImageUris() {
        return imageUris;
    }

    public int getDetailBackgroundRes() {
        return detailBackgroundRes;
    }
}
