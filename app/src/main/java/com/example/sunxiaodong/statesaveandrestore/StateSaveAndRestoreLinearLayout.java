package com.example.sunxiaodong.statesaveandrestore;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * Created by sunxiaodong on 2016/2/24.
 */
public class StateSaveAndRestoreLinearLayout extends LinearLayout {

    private static final String TAG = StateSaveAndRestoreLinearLayout.class.getSimpleName();
    private static final String SXD = "sxd";

    public StateSaveAndRestoreLinearLayout(Context context) {
        super(context);
        Log.i(SXD, TAG + "--StateSaveAndRestoreLinearLayout++1");
    }

    public StateSaveAndRestoreLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i(SXD, TAG + "--StateSaveAndRestoreLinearLayout++2");
    }

    public StateSaveAndRestoreLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.i(SXD, TAG + "--StateSaveAndRestoreLinearLayout++3");
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        Log.i(SXD, TAG + "--onRestoreInstanceState++state:" + state);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Log.i(SXD, TAG + "--onSaveInstanceState");
        return super.onSaveInstanceState();
    }

}
