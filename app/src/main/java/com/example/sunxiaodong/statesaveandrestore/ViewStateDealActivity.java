package com.example.sunxiaodong.statesaveandrestore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sunxiaodong on 2016/2/24.
 */
public class ViewStateDealActivity extends AppCompatActivity {

    private static final String TAG = ViewStateDealActivity.class.getSimpleName();
    private static final String SXD = "sxd";

    private StateSaveAndRestoreLinearLayout mLinearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_state_deal_activity);
        initView();
    }

    private void initView() {
        mLinearLayout = (StateSaveAndRestoreLinearLayout) this.findViewById(R.id.linear_layout);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
