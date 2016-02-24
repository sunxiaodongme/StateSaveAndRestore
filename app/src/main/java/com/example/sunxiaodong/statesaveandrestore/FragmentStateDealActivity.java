package com.example.sunxiaodong.statesaveandrestore;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by sunxiaodong on 16/2/23.
 */
public class FragmentStateDealActivity extends AppCompatActivity {

    private static final String TAG = FragmentStateDealActivity.class.getSimpleName();
    private static final String SXD = "sxd";

    public static final String STR_STATE_KEY = "str_state_key";

    private StateSaveAndRestoreFragment mStateSaveAndRestoreFragment;
    private FragmentManager mFm;

    private String mString;//状态变量的值，需要自己保存和恢复

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_state_deal_activity);
        mFm = getSupportFragmentManager();
        mStateSaveAndRestoreFragment = (StateSaveAndRestoreFragment) mFm.findFragmentByTag(StateSaveAndRestoreFragment.TAG);
        Log.i(SXD, TAG + "--onCreate++mStateSaveAndRestoreFragment:" + mStateSaveAndRestoreFragment);
        if (mStateSaveAndRestoreFragment == null) {
            mStateSaveAndRestoreFragment = StateSaveAndRestoreFragment.newInstance();
            mFm.beginTransaction().add(R.id.content_layout, mStateSaveAndRestoreFragment, StateSaveAndRestoreFragment.TAG).commit();
        }
        if (savedInstanceState == null) {
            Log.i(SXD, TAG + "--onCreate++savedInstanceState:" + savedInstanceState);
        } else {
            Log.i(SXD, TAG + "--onCreate++savedInstanceState++mString:" + savedInstanceState.getString(STR_STATE_KEY));
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(SXD, TAG + "--onRestoreInstanceState++onRestoreInstanceState++mString:" + savedInstanceState.getString(STR_STATE_KEY));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mString = "Fragment宿主中的变量";
        Log.i(SXD, TAG + "--onResume++mString:" + mString);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STR_STATE_KEY, mString);
        Log.i(SXD, TAG + "--onSaveInstanceState++outState++mString:" + outState.getString(STR_STATE_KEY));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(SXD, TAG + "--onDestroy");
    }

}
