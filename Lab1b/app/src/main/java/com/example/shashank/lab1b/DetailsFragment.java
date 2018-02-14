package com.example.shashank.lab1b;

import android.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Shashank on 13-02-2018.
 */

public class DetailsFragment extends Fragment {
    public static DetailsFragment newInstance(int index){
        DetailsFragment f = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("index",index);
        f.setArguments(args);
        return f;
    }

    public int getShownIndex(){
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflator, ViewGroup container, Bundle savedInstanceState){
        ScrollView scroller = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getActivity().getResources().getDisplayMetrics());
        text.setPadding(padding, padding, padding, padding);
        scroller.addView(text);
        text.setText(Ipsum.Articles[getShownIndex()]);
        return scroller;
    }
}
