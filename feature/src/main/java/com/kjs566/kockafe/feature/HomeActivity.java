package com.kjs566.kockafe.feature;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kjs566.kockafe.base.BaseActivity;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflateContent(R.layout.activity_home_content);
        setTitle(R.string.home_title);
        setBackgroundImage(R.drawable.home_background);

        int[] buttonsIds = {
                R.id.btn_about,
                R.id.btn_cats,
                R.id.btn_contact,
                R.id.btn_game1,
                R.id.btn_game2,
                R.id.btn_share
        };
        for (int id : buttonsIds) {
            findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Class<?> activityCls = null;

        int id = view.getId();
        if (id == R.id.btn_about) {
            activityCls = AboutActivity.class;
        } else if (id == R.id.btn_cats) {

        } else if (id == R.id.btn_contact) {
            activityCls = ContactActivity.class;
        } else if (id == R.id.btn_game1) {

        } else if (id == R.id.btn_game2) {

        } else if (id == R.id.btn_share) {

        }

        if(activityCls == null){
            Toast.makeText(this, "Screen not implemented yet :( ", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, activityCls);
            startActivity(intent);
        }
    }
}
