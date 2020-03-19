package ru.sushina.test_1.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getLogTag(), "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(getLogTag(), "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getLogTag(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(getLogTag(), "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(getLogTag(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(getLogTag(), "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(getLogTag(), "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(getLogTag(), "onRestoreInstanceState");
    }

    private String getLogTag() {
        return getClass().getSimpleName() + " Lifecycle";
    }
}
