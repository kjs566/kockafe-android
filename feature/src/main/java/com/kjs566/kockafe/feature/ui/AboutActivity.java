package com.kjs566.kockafe.feature.ui;

import android.os.Bundle;

import com.kjs566.kockafe.base.BaseActivity;
import com.kjs566.kockafe.feature.R;

public class AboutActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflateContent(R.layout.activity_about_content);
        setTitle(R.string.about_title);
        showBackButton();
        setBackgroundImage(R.drawable.about_background);
    }
}
