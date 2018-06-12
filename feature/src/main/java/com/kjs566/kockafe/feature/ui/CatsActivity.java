package com.kjs566.kockafe.feature.ui;

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

    private class CatViewHolder extends RecyclerView.ViewHolder{
        private final TextView mCatName;
        private final ImageView mCatImage;

        public CatViewHolder(View itemView) {
            super(itemView);
            mCatName = itemView.findViewById(R.id.tv_name);
            mCatImage = itemView.findViewById(R.id.iv_image);
        }

        public void setName(@StringRes int nameRes){
            mCatName.setText(nameRes);
        }

        public void setImage(@DrawableRes int imageRes){
            mCatImage.setImageDrawable(getResources().getDrawable(imageRes));
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
            if(cat.getImagesRes().length > 0) {
                holder.setImage(cat.getImagesRes()[0]);
            }
            holder.setName(cat.getNameRes());
        }

        @Override
        public int getItemCount() {
            if(mCatsList == null)
                return 0;
            else return mCatsList.size();
        }
    }
}
