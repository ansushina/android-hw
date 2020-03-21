package ru.sushina.test_1.app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            final ListFragment fragment = new ListFragment();
            fragmentTransaction.add(R.id.main_layout, fragment);
            fragmentTransaction.commit();
        }
    }
}
