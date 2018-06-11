package com.kjs566.kockafe.base;

import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kjs566.kockafe.R;

/**
 * Base activity with customizable toolbar.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TextView mTitleTextView;
    private ViewGroup mContentView;
    private ImageView mBackgroundImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mToolbar = findViewById(R.id.toolbar);
        mTitleTextView = mToolbar.findViewById(R.id.tv_title);
        mContentView = findViewById(R.id.content_view);
        mBackgroundImageView = findViewById(R.id.iv_background);

        setSupportActionBar(mToolbar);
    }

    /**
     * Inflates the content of the activity.
     * @param contentLayout Layout to inflate.
     */
    protected void inflateContent(@LayoutRes int contentLayout){
        getLayoutInflater().inflate(contentLayout, mContentView);
    }

    @Override
    public void setTitle(int titleId) {
        mTitleTextView.setText(titleId);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitleTextView.setText(title);
    }

    public void setBackgroundImage(@DrawableRes int drawableRes){
        mBackgroundImageView.setImageDrawable(getResources().getDrawable(drawableRes));
    }
}
