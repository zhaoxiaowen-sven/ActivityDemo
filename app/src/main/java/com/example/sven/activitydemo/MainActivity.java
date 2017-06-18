
package com.example.sven.activitydemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ActivityLife";

    private static final String EDIT_TAG = "edit_tag";
    private EditText editText;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveInstanceState...");
        super.onSaveInstanceState(outState);
        String s = editText.getText().toString();
        outState.putString(EDIT_TAG,s);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState...");
        //onCreate 或者这里恢复数据均可
        editText.setText(savedInstanceState.getString(EDIT_TAG));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, "onConfigurationChanged..."+newConfig.toString());
    }

    public void showDialogActivity(View view) {
        Intent intent =  new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate...");
        editText = (EditText) findViewById(R.id.edit_content);
        if (savedInstanceState != null){
            Log.i(TAG, "onCreate savedInstanceState is not null");
            editText.setText(savedInstanceState.getString(EDIT_TAG));
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy...");
    }
}
