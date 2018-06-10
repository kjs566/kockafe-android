package com.kjs566.kockafe.feature;

import android.os.Bundle;

import com.kjs566.kockafe.base.BaseActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflateContent(R.layout.activity_home_content);
        setTitle(R.string.home_title);
    }
}
