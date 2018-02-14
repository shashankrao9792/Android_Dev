package com.example.shashank.lab1b;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Shashank on 13-02-2018.
 */

public class TitlesFragment extends ListFragment {
    boolean mDualPane;
    int mCurCheckPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, Ipsum.Headlines));
        View detailsFrame = getActivity().findViewById(R.id.details);

        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if(savedInstanceState!=null){
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

        if(mDualPane){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(mCurCheckPosition);
        }
        else{
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(mCurCheckPosition, true);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        showDetails(position);
    }

    void showDetails(int index){
        mCurCheckPosition = index;
        if(mDualPane){
            getListView().setItemChecked(index, true);
            DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
            if(details==null || details.getShownIndex() != index){
                details = DetailsFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.details, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }
        else{
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }
}
