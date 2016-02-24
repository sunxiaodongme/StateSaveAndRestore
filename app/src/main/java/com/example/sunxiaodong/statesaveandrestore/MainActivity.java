package com.example.sunxiaodong.statesaveandrestore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String SXD = "sxd";

    private Button mGoStateDealActivity;
    private Button mGoStateDealFragment;
    private Button mGoStateDealView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mGoStateDealActivity = (Button) this.findViewById(R.id.go_state_deal_activity);
        mGoStateDealActivity.setOnClickListener(this);
        mGoStateDealFragment = (Button) this.findViewById(R.id.go_state_deal_fragment);
        mGoStateDealFragment.setOnClickListener(this);
        mGoStateDealView = (Button) this.findViewById(R.id.go_state_deal_view);
        mGoStateDealView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_state_deal_activity:
                goStateDealActivity();
                break;
            case R.id.go_state_deal_fragment:
                goStateDealFragment();
                break;
            case R.id.go_state_deal_view:
                goStateDealView();
                break;
        }
    }

    private void goStateDealActivity() {
        Intent intent = new Intent(this, StateSaveAndRestoreActivity.class);
        startActivity(intent);
    }

    private void goStateDealFragment() {
        Intent intent = new Intent(this, FragmentStateDealActivity.class);
        startActivity(intent);
    }

    private void goStateDealView() {
        /*Intent intent = new Intent(this, PagerAdapterActivity.class);
        startActivity(intent);*/
    }

}
