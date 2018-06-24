package com.kjs566.kockafe.feature.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kjs566.imagegallery.ui.IGDetailActivity;
import com.kjs566.kockafe.base.BaseActivity;
import com.kjs566.kockafe.feature.R;
import com.kjs566.kockafe.feature.model.CatRecord;
import com.kjs566.kockafe.feature.repository.CatsRepository;

public class CatDetailActivity extends BaseActivity implements View.OnClickListener {
    public static final String CAT_ID_EXTRA_KEY = "cat_id";

    private CatRecord mCatRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflateContent(R.layout.activity_cat_detail_content);
        showBackButton();

        String catId = getIntent().getStringExtra(CAT_ID_EXTRA_KEY);
        if(catId == null) {
            finish();
        }

        mCatRecord = CatsRepository.getInstance().getCatById(catId);
        setTitle(mCatRecord.getNameRes());
        setBackgroundImage(mCatRecord.getDetailBackgroundRes());

        TextView descriptionTextView = findViewById(R.id.tv_cat_description);
        descriptionTextView.setText(mCatRecord.getDescriptionRes());

        findViewById(R.id.btn_gallery).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_gallery){
            Intent intent = new IGDetailActivity.IntentBuilder()
                    .withImageUris(mCatRecord.getImageUris())
                    .withSharingWatermark(R.mipmap.ic_launcher)
                    .build(this);
            startActivity(intent);
        }
    }
}
