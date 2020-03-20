package ru.sushina.test_1.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.app.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.sushina.test_1.app.adapter.ItemAdapter;

public class ListFragment extends Fragment {

    private static final int COLUMN_VERTICAL = 3;
    private static final int COLUMN_HORISONTAL= 4;
    private static final int NUMBERS_COUNT = 10;

    private final String key_data = "data_array";

    private ItemAdapter itemAdapter;
    private List<Integer> numArray = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.list_fragment, null);

        int columnCount = COLUMN_VERTICAL;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columnCount = COLUMN_HORISONTAL;
        }

        final RecyclerView recView = view.findViewById(R.id.recyclerview);
        recView.setLayoutManager(new GridLayoutManager(view.getContext(), columnCount));

        if (savedInstanceState != null) {
            numArray = savedInstanceState.getIntegerArrayList(key_data);
        }

        if (savedInstanceState == null) {
            numArray.clear();
            for (int i = 0; i < NUMBERS_COUNT; i++) {
                numArray.add(i+1);
            }
        }
        itemAdapter = new ItemAdapter(getActivity());
        recView.setAdapter(itemAdapter);
        itemAdapter.setItems(numArray);


        final Button button = view.findViewById(R.id.list_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numArray.add(itemAdapter.getItemCount() + 1);
                itemAdapter.setItems(numArray);
            }
        });

        return view;
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle state) {
        super.onSaveInstanceState(state);
        state.putIntegerArrayList(key_data, new ArrayList<>(numArray));
    }
}
