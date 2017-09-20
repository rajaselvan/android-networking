package com.ideas2it.apiexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

  private static final String SARG_PLACES = "place_tag";
  private List<Places> mPlaces = new ArrayList<>();

  public ListFragment() {
  }

  public static ListFragment newInstance(ArrayList<Places> placesArrayList) {
    ListFragment fragment = new ListFragment();
    Bundle args = new Bundle();
    args.putParcelableArrayList(SARG_PLACES, placesArrayList);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mPlaces = getArguments().getParcelableArrayList(SARG_PLACES);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_item_list, container, false);

    if (view instanceof RecyclerView) {
      Context context = view.getContext();
      RecyclerView recyclerView = (RecyclerView) view;
      recyclerView.setLayoutManager(new LinearLayoutManager(context));
      recyclerView.setAdapter(new ListRecyclerViewAdapter(mPlaces));
      recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

    }
    return view;
  }
}
