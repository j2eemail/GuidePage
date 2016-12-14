package com.example.guidepage.guidepage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/12/14.
 */
public class GuidePageFragment extends GuidePageBaseFragment {

    private ImageView imageView;

    @Override
    protected int getLayoutId() {
        return R.layout.guidepage;
    }

    @Override
    protected void initView(View view) {
        imageView = (ImageView) view.findViewById(R.id.image_id);
    }

    @Override
    protected void initData(Bundle bundle) {
        if (bundle != null) {
            String key = bundle.getString(Constants.IMAGE_KEY);
            int imageId = getDrawableId(key);
            imageView.setImageResource(imageId);
        }
    }

    public int getDrawableId(String key) {
        return context.getResources().getIdentifier(key, "mipmap", context.getPackageName());
    }
}
