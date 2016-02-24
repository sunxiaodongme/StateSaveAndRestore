package com.example.sunxiaodong.statesaveandrestore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by sunxiaodong on 16/2/23.
 */
public class StateSaveAndRestoreFragment extends Fragment {

    public static final String TAG = StateSaveAndRestoreFragment.class.getSimpleName();
    private static final String SXD = "sxd";

    private static final String STATE_KEY = "state_key";

    private EditText mEditText;//EditText中的值，系统默认就会恢复
    private String mEditTextStr;//状态变量的值，需要自己保存和恢复

    public static StateSaveAndRestoreFragment newInstance() {
        StateSaveAndRestoreFragment stateSaveAndRestoreFragment = new StateSaveAndRestoreFragment();
        return stateSaveAndRestoreFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);//该方法设置了状态变量是否会在状态改变重建时销毁
        if (savedInstanceState == null) {
            Log.i(SXD, TAG + "--onCreate++savedInstanceState:" + savedInstanceState);
        } else {
            Log.i(SXD, TAG + "--onCreate++savedInstanceState++mEditTextStr:" + savedInstanceState.getString(STATE_KEY));
            Log.i(SXD, TAG + "--onCreate++savedInstanceState++mString:" + savedInstanceState.getString(FragmentStateDealActivity.STR_STATE_KEY));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.state_save_and_restore_fragment, container, false);
        if (savedInstanceState == null) {
            Log.i(SXD, TAG + "--onCreateView++savedInstanceState:" + savedInstanceState);
        } else {
            Log.i(SXD, TAG + "--onCreateView++savedInstanceState++mEditTextStr:" + savedInstanceState.getString(STATE_KEY));
            Log.i(SXD, TAG + "--onCreateView++savedInstanceState++mString:" + savedInstanceState.getString(FragmentStateDealActivity.STR_STATE_KEY));
        }
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        mEditText = (EditText) rootView.findViewById(R.id.edit_text);
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            Log.i(SXD, TAG + "--onViewCreated++savedInstanceState:" + savedInstanceState);
        } else {
            Log.i(SXD, TAG + "--onViewCreated++savedInstanceState++mEditTextStr:" + savedInstanceState.getString(STATE_KEY));
            Log.i(SXD, TAG + "--onViewCreated++savedInstanceState++mString:" + savedInstanceState.getString(FragmentStateDealActivity.STR_STATE_KEY));
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState == null) {
            Log.i(SXD, TAG + "--onActivityCreated++savedInstanceState:" + savedInstanceState);
        } else {
            Log.i(SXD, TAG + "--onActivityCreated++savedInstanceState++mEditTextStr:" + savedInstanceState.getString(STATE_KEY));
            Log.i(SXD, TAG + "--onActivityCreated++savedInstanceState++mString:" + savedInstanceState.getString(FragmentStateDealActivity.STR_STATE_KEY));
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState == null) {
            Log.i(SXD, TAG + "--onViewStateRestored++savedInstanceState:" + savedInstanceState);
        } else {
            Log.i(SXD, TAG + "--onViewStateRestored++savedInstanceState++mEditTextStr:" + savedInstanceState.getString(STATE_KEY));
            Log.i(SXD, TAG + "--onViewStateRestored++savedInstanceState++mString:" + savedInstanceState.getString(FragmentStateDealActivity.STR_STATE_KEY));
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(SXD, TAG + "--onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(SXD, TAG + "--onResume");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i(SXD, TAG + "--onHiddenChanged++hidden:" + hidden);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(SXD, TAG + "--onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_KEY, mEditTextStr);
        Log.i(SXD, TAG + "--onSaveInstanceState++outState++mEditTextStr:" + outState.getString(STATE_KEY));
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(SXD, TAG + "--onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(SXD, TAG + "--onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(SXD, TAG + "--onDestroy");
    }

}
