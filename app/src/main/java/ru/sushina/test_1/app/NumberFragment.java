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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NumberFragment extends Fragment {
    private static final String NUMBER_KEY = "number";
    public int number = 0;

    static public NumberFragment newInstance(int number) {
        final NumberFragment fragment = new NumberFragment();
        final Bundle bundle = new Bundle();
        bundle.putInt(NUMBER_KEY, number);
        fragment.setArguments(bundle);

        return fragment;
    }


    public View onCreateView(@NonNull  LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.number_fragment, null) ;
        final TextView textView = view.findViewById(R.id.number_text);
        final Bundle arguments = getArguments();
        if (arguments != null) {
            number = arguments.getInt(NUMBER_KEY);
        }
        textView.setText(String.valueOf(number));

        int textColor;
        if (number % 2 == 0) {
            textColor = Color.RED;
        } else {
            textColor = Color.BLUE;
        }
        textView.setTextColor(textColor);

        return view;
    }
}