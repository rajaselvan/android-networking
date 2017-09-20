package com.ideas2it.apiexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class ListRecyclerViewAdapter extends RecyclerView.Adapter<ListRecyclerViewAdapter.ViewHolder> {

  private final List<Places> mValues;

  public ListRecyclerViewAdapter(List<Places> placesList) {
    mValues = placesList;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.mPlaces = mValues.get(position);
    holder.mPlaceName.setText(mValues.get(position).getName());
    holder.mPlaceAdress.setText(mValues.get(position).getAddress());
    holder.mPlaceDate.setText(mValues.get(position).getDate());
    Picasso.with(holder.mPlaceImage.getContext()).load(mValues.get(position).getImageUrl()).into(holder.mPlaceImage);
//    new ImageDownloaderTask(holder.mPlaceImage).execute(mValues.get(position).getImageUrl());
  }

  @Override
  public int getItemCount() {
    return mValues.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public Places mPlaces;
    public final TextView mPlaceName;
    public final TextView mPlaceAdress;
    public final TextView mPlaceDate;
    public final ImageView mPlaceImage;

    public ViewHolder(View view) {
      super(view);
      mView = view;
      mPlaceName = (TextView) view.findViewById(R.id.places_name_value);
      mPlaceAdress = (TextView) view.findViewById(R.id.places_address_value);
      mPlaceDate = (TextView) view.findViewById(R.id.places_date_value);
      mPlaceImage = (ImageView) view.findViewById(R.id.places_image);
    }
  }
}
