package com.ehc.rovnostandroid.adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ehc.rovnostandroid.R;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by ehc on 16/2/16.
 */
public class RatingsAdapter extends RecyclerView.Adapter<RatingsAdapter.ViewHolder> {
    private ArrayList<String> mDataset;
    public Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public RatingBar ratingBar;

        public ViewHolder(View v) {
            super(v);
            ratingBar = (RatingBar) v.findViewById(R.id.rating_bar);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RatingsAdapter(Context applicationContext) {
        context=applicationContext;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RatingsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rating_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        LayerDrawable stars = (LayerDrawable) holder.ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(ContextCompat.getColor(context,R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(ContextCompat.getColor(context,R.color.bg_theme), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(0).setColorFilter(ContextCompat.getColor(context,R.color.search_hint_color), PorterDuff.Mode.SRC_ATOP);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 10;
    }
}
