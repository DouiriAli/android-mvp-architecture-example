package com.example.mvp.androidmvparchitectureexample.ui.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.mvp.androidmvparchitectureexample.R;
import com.example.mvp.androidmvparchitectureexample.data.local.ArticleEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ali DOUIRI on 25/04/2018.
 * my.alidouiri@gmail.com
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArticleHolder> {

    private static final String TAG = NewsAdapter.class.getSimpleName();

    private List<ArticleEntity> mItems;
    private Context mContext;
    private final OnItemClickListener mListener;

    public NewsAdapter(Context context, List<ArticleEntity> items, OnItemClickListener listener) {

        this.mContext = context;
        this.mItems = items;
        this.mListener = listener;
    }

    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mItemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);

        return new ArticleHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(ArticleHolder holder, int position) {

        holder.bind(mContext, mItems.get(position), mListener);

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setItems(List<ArticleEntity> mItems) {

        if (mItems != null && !mItems.isEmpty()) {

            this.mItems = mItems;
            notifyDataSetChanged();
        }

    }

    static class ArticleHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.thumbnail)
        ImageView mThumbnail;
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.description)
        TextView mDescription;
        @BindView(R.id.progress)
        ProgressBar mProgress;

        public ArticleHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bind(Context context, final ArticleEntity item, final OnItemClickListener listener) {

            if (item != null)
            {

                if (item.getTitle() != null)
                    mTitle.setText(item.getTitle());

                if (item.getDescription() != null)
                    mDescription.setText(item.getDescription());

                if (item.getUrlToImage() != null)
                {
                    Glide
                            .with(context)
                            .load(item.getUrlToImage())
                            .listener(new RequestListener<String, GlideDrawable>() {
                                @Override
                                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                    if (mProgress != null)
                                        mProgress.setVisibility(View.GONE);

                                    return false;
                                }

                                @Override
                                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                    if (mProgress != null)
                                        mProgress.setVisibility(View.GONE);

                                    return false;
                                }
                            })
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .centerCrop()
                            .crossFade()
                            .into(mThumbnail);
                }

            }

            itemView.setOnClickListener(view -> listener.onItemClick(item));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(ArticleEntity item);
    }
}

