package com.example.sunxiaodong.statesaveandrestore;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.Random;

/**
 * Created by sunxiaodong on 2016/2/24.
 */
public class StateSaveAndRestoreLinearLayout extends LinearLayout {

    private static final String TAG = StateSaveAndRestoreLinearLayout.class.getSimpleName();
    private static final String SXD = "sxd";

    private Integer mStateVar;//状态变量，当该View销毁时，其会被销毁

    public StateSaveAndRestoreLinearLayout(Context context) {
        super(context);
        Log.i(SXD, TAG + "--StateSaveAndRestoreLinearLayout++1");
    }

    public StateSaveAndRestoreLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i(SXD, TAG + "--StateSaveAndRestoreLinearLayout++beforeRandom++mStateVar:" + mStateVar);
        mStateVar = new Random().nextInt(10);
        Log.i(SXD, TAG + "--StateSaveAndRestoreLinearLayout++afterRandom++mStateVar:" + mStateVar);
    }

    public StateSaveAndRestoreLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.i(SXD, TAG + "--StateSaveAndRestoreLinearLayout++3");
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        SaveState savedState = (SaveState) state;
        super.onRestoreInstanceState(savedState.getParcelable());
        mStateVar = savedState.getSavedState();
        Log.i(SXD, TAG + "--onRestoreInstanceState++mStateVar:" + mStateVar);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Log.i(SXD, TAG + "--onSaveInstanceState++mStateVar:" + mStateVar);
        SaveState state = new SaveState(super.onSaveInstanceState());
        state.setSavedState(mStateVar);
        return state;
    }

    /**
     * 保存View状态数据体
     */
    static class SaveState implements Parcelable {

        private Integer mSavedState;//保存View中的状态变量
        private Parcelable mParcelable;//保存View的默认状态

        SaveState(Parcelable parcelable) {
            mParcelable = parcelable;
        }

        protected SaveState(Parcel in) {
            mSavedState = in.readInt();
        }

        public static final Creator<SaveState> CREATOR = new Creator<SaveState>() {
            @Override
            public SaveState createFromParcel(Parcel in) {
                return new SaveState(in);
            }

            @Override
            public SaveState[] newArray(int size) {
                return new SaveState[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(mSavedState);
        }

        public Integer getSavedState() {
            return mSavedState;
        }

        public void setSavedState(Integer mSavedState) {
            this.mSavedState = mSavedState;
        }

        public Parcelable getParcelable() {
            return mParcelable;
        }

        public void setParcelable(Parcelable mParcelable) {
            this.mParcelable = mParcelable;
        }
    }

}
