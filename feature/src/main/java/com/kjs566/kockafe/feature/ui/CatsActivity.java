package com.kjs566.kockafe.feature.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kjs566.kockafe.base.BaseActivity;
import com.kjs566.kockafe.feature.R;
import com.kjs566.kockafe.feature.model.CatRecord;
import com.kjs566.kockafe.feature.repository.CatsRepository;

import java.util.List;

public class CatsActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private List<CatRecord> mCatsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflateContent(R.layout.activity_cats_content);
        setTitle(R.string.our_fluffy_friends);
        showBackButton();
        
        mRecyclerView = findViewById(R.id.rv_list);
        mCatsList = CatsRepository.getInstance().getCatsList();
        mRecyclerView.setAdapter(new CatsAdapter());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void goToCatDetail(String catId){
        Intent intent = new Intent(this, CatDetailActivity.class);
        intent.putExtra(CatDetailActivity.CAT_ID_EXTRA_KEY, catId);
        startActivity(intent);
    }

    private class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mCatName;
        private final ImageView mCatImage;
        private String mCatId;

        public CatViewHolder(View itemView) {
            super(itemView);
            mCatName = itemView.findViewById(R.id.tv_name);
            mCatImage = itemView.findViewById(R.id.iv_image);
            itemView.setOnClickListener(this);
        }

        public void updateView(String catId, @StringRes int nameRes, @DrawableRes int imageRes){
            mCatId = catId;
            mCatName.setText(nameRes);
            mCatImage.setImageDrawable(getResources().getDrawable(imageRes));

        }

        @Override
        public void onClick(View view) {
            goToCatDetail(mCatId);
        }
    }

    private class CatsAdapter extends RecyclerView.Adapter<CatViewHolder>{

        @Override
        public CatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CatViewHolder(getLayoutInflater().inflate(R.layout.cat_item, parent, false));
        }

        @Override
        public void onBindViewHolder(CatViewHolder holder, int position) {
            final CatRecord cat = mCatsList.get(position);
            holder.updateView(cat.getId(), cat.getNameRes(), cat.getImagesRes()[0]);
        }

        @Override
        public int getItemCount() {
            if(mCatsList == null)
                return 0;
            else return mCatsList.size();
        }
    }
}
