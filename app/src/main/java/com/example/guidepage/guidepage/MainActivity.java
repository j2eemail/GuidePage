package com.example.guidepage.guidepage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private Fragment[] arrayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏

        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpage_id);

        arrayFragment = new Fragment[3];

        GuidePageFragment aFragment=  new GuidePageFragment();
        Bundle aBundle = new Bundle();
        aBundle.putString(Constants.IMAGE_KEY,Constants.IMAGE_A);
        aFragment.setArguments(aBundle);
        arrayFragment[0] = aFragment;

        GuidePageFragment bFragment=  new GuidePageFragment();
        Bundle bBundle = new Bundle();
        bBundle.putString(Constants.IMAGE_KEY,Constants.IMAGE_B);
        bFragment.setArguments(bBundle);
        arrayFragment[1] = bFragment;

        GuidePageFragment cFragment=  new GuidePageFragment();
        Bundle cBundle = new Bundle();
        cBundle.putString(Constants.IMAGE_KEY,Constants.IMAGE_C);
        cFragment.setArguments(cBundle);
        arrayFragment[2] = cFragment;

        GuidePageFragmentPagerAdapter guidePageFragmentPagerAdapter = new GuidePageFragmentPagerAdapter(getSupportFragmentManager(), arrayFragment);
        viewPager.setAdapter(guidePageFragmentPagerAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewPager.removeAllViews();
        arrayFragment = null;
        viewPager = null;
    }
}
