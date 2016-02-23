package com.example.sunxiaodong.statesaveandrestore;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String SXD = "sxd";

    private static final String STATE_KEY = "state_key";

    private EditText mEditText;//EditText中的值，系统默认就会恢复
    private String mEditTextStr;//状态变量的值，需要自己保存和恢复

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            Log.i(SXD, TAG + "--onCreate++savedInstanceState:" + savedInstanceState);
        } else {
            Log.i(SXD, TAG + "--onCreate++savedInstanceState++mEditTextStr:" + savedInstanceState.getString(STATE_KEY));
        }
        initView();
    }

    private void initView() {
        mEditText = (EditText) this.findViewById(R.id.edit_text);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mEditTextStr = mEditText.getText().toString();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(SXD, TAG + "--onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mEditTextStr = savedInstanceState.getString(STATE_KEY);
        Log.i(SXD, TAG + "--onRestoreInstanceState++savedInstanceState++mEditTextStr:" + mEditTextStr);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(SXD, TAG + "--onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(SXD, TAG + "--onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(SXD, TAG + "--onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(SXD, TAG + "--onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_KEY, mEditTextStr);
        Log.i(SXD, TAG + "--onSaveInstanceState++outState++mEditTextStr:" + outState.getString(STATE_KEY));
    }

}
