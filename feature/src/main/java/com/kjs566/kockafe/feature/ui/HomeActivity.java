package com.kjs566.kockafe.feature.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.kjs566.imagegallery.IGImageSharing;
import com.kjs566.imagegallery.IGWatermarkTransformation;
import com.kjs566.kockafe.base.BaseActivity;
import com.kjs566.imagegallery.IGImagePicker;
import com.kjs566.kockafe.feature.R;

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private static final int IMAGE_PICKER_REQUEST_ID = 31234;
    private IGImageSharing mImageSharing;
    private IGWatermarkTransformation mWatermarkTransformation;

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

        mWatermarkTransformation = new IGWatermarkTransformation(this, R.mipmap.ic_launcher);
    }

    @Override
    public void onClick(View view) {
        Class<?> activityCls = null;
        boolean implementedFlag = false;


        int id = view.getId();
        if (id == R.id.btn_about) {
            activityCls = AboutActivity.class;
        } else if (id == R.id.btn_cats) {
            activityCls = CatsActivity.class;
        } else if (id == R.id.btn_contact) {
            activityCls = ContactActivity.class;
        } else if (id == R.id.btn_game1) {

        } else if (id == R.id.btn_game2) {

        } else if (id == R.id.btn_share) {
            Intent chooseImageIntent = IGImagePicker.createImagePicker(this);
            startActivityForResult(chooseImageIntent, IMAGE_PICKER_REQUEST_ID);
            implementedFlag = true;
        }

        if(activityCls == null && !implementedFlag){
            Toast.makeText(this, "Screen not implemented yet :( ", Toast.LENGTH_SHORT).show();
        }else if(activityCls != null){
            Intent intent = new Intent(this, activityCls);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case IMAGE_PICKER_REQUEST_ID:
                Uri imageUri = IGImagePicker.getImageUriFromResult(this, resultCode, data);

                RequestOptions options = new RequestOptions()
                        .transform(mWatermarkTransformation);

                Glide.with(this).asBitmap().apply(options).load(imageUri).into(new SimpleTarget<Bitmap>(1440, 2560){
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        if(mImageSharing == null){
                            mImageSharing = new IGImageSharing(HomeActivity.this);
                        }
                        mImageSharing.saveAndShareImage(resource);
                    }
                });

                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }
}
