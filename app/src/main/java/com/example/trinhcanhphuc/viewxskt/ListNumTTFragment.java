package com.example.trinhcanhphuc.viewxskt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListNumTTFragment extends Fragment {

    TextView txtNumTT;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int num = getArguments().getInt("number");
        View view = inflater.inflate(R.layout.fragment_list_num_tt, container, false);
        txtNumTT = (TextView) view.findViewById(R.id.txtNumTT);
        txtNumTT.setText(String.valueOf(num));
        return view;
    }
}