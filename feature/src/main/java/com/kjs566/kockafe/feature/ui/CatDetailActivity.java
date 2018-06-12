package com.kjs566.kockafe.feature.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kjs566.kockafe.base.BaseActivity;
import com.kjs566.kockafe.feature.R;
import com.kjs566.kockafe.feature.model.CatRecord;
import com.kjs566.kockafe.feature.repository.CatsRepository;

public class CatDetailActivity extends BaseActivity implements View.OnClickListener {
    public static final String CAT_ID_EXTRA_KEY = "cat_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflateContent(R.layout.activity_cat_detail_content);
        showBackButton();

        String catId = getIntent().getStringExtra(CAT_ID_EXTRA_KEY);
        if(catId == null) {
            finish();
        }

        CatRecord cat = CatsRepository.getInstance().getCatById(catId);
        setTitle(cat.getNameRes());
        setBackgroundImage(cat.getImagesRes()[0]);

        TextView descriptionTextView = findViewById(R.id.tv_cat_description);
        descriptionTextView.setText(cat.getDescriptionRes());

        findViewById(R.id.btn_gallery).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_gallery){
            Toast.makeText(this, "Screen not implemented yet :(", Toast.LENGTH_SHORT).show();
        }
    }
}
