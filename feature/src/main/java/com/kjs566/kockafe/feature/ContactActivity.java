package com.kjs566.kockafe.feature;

import android.os.Bundle;

import com.kjs566.kockafe.base.BaseActivity;

public class ContactActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.contact);
        setBackgroundImage(R.drawable.contact_background);
        inflateContent(R.layout.activity_contact_content);
    }
}
