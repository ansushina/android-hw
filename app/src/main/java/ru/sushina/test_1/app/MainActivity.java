package ru.sushina.test_1.app;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment f = getFragmentManager().findFragmentById(R.layout.list_fragment);
        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            ListFragment fragment = new ListFragment();
            fragmentTransaction.add(R.id.main_layout, fragment);
            fragmentTransaction.commit();
        }
    }



    private String getLogTag() {
        return getClass().getSimpleName() + " Lifecycle";
    }
}
