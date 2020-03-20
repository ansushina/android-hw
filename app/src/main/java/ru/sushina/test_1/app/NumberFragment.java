package ru.sushina.test_1.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
import android.widget.TextView;

public class NumberFragment extends Fragment {
    private static final String NUMBER_KEY = "number";
    public int number = 0;

    static public NumberFragment newInstance(int number) {
        NumberFragment fragment = new NumberFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NUMBER_KEY, number);
        fragment.setArguments(bundle);

        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.number_fragment, null) ;
        TextView tView = view.findViewById(R.id.number_text);
        Bundle arguments = getArguments();
        if (arguments != null) {
            number = arguments.getInt(NUMBER_KEY);
        }
        tView.setText(String.valueOf(number));

        int textColor;
        if (number%2 == 0) {
            textColor = Color.RED;
        } else {
            textColor = Color.BLUE;
        }
        tView.setTextColor(textColor);

        return view;
    }
}