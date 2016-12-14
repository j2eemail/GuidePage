package com.example.guidepage.guidepage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/12/14.
 */
public abstract class GuidePageBaseFragment extends Fragment {

    protected Context context;
    protected Activity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);//关联布局文件
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
        context = activity.getApplicationContext();
        initData(getArguments());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        activity = null;
        context = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected String getRString(int resId) {
        return getResources().getString(resId);
    }

    protected String getRString(int resId, String txt) {
        return getResources().getString(resId, txt);
    }

    protected int getResColor(int resId) {
        return ContextCompat.getColor(getActivity(), resId);
    }

    protected abstract int getLayoutId();//获取布局文件ID

    protected abstract void initView(View view);

    protected abstract void initData(Bundle bundle);
}
