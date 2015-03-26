package com.example.ayush.CoffeeCatchDemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CoffeeCatchActivity extends Activity
{
    private static final String TAG = "coffee-catch-demo";
    private Button _testButton;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        _testButton = (Button) findViewById(R.id.test_button);
        setButtonClickListener();
    }

    private void setButtonClickListener()
    {
        _testButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                testCoffeeCatch();
            }
        });
    }

    private void testCoffeeCatch()
    {
        Log.d(TAG, "testCoffeeCatch");
        try {
            nativeCrashingFunction();
            Log.d(TAG, "No native crash occurred");
        } catch (Throwable t) {
            Log.e(TAG, t.getMessage(), t);
            Toast.makeText(this, "Native crash caught", Toast.LENGTH_SHORT).show();
        }
    }

    private native void nativeCrashingFunction();

    static {
        System.loadLibrary("coffee_catch_demo");
    }

}
