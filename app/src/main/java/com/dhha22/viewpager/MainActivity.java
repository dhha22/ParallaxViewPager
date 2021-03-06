package com.dhha22.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.dhha22.parallaxviewpager.CirclePageIndicator;
import com.dhha22.parallaxviewpager.LinePageIndicator;
import com.dhha22.parallaxviewpager.PageIndicator;
import com.dhha22.parallaxviewpager.ParallaxViewPager;

public class MainActivity extends AppCompatActivity {
    ViewPager mPager;
    DemoParallaxAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setBackgroundColor(0xFF000000);

        ParallaxViewPager pt = new ParallaxViewPager((R.id.image));
        pt.setBorder(0);
        pt.setSpeed(0.6f);
        mPager.setPageTransformer(false, pt);

        mAdapter = new DemoParallaxAdapter(getSupportFragmentManager());
        mAdapter.setPager(mPager); //only for this taransformer

        Bundle bNina = new Bundle();
        bNina.putInt("image", R.drawable.bg_nina);
        bNina.putString("name", "Nina");
        DemoParallaxFragment pfNina = new DemoParallaxFragment();
        pfNina.setArguments(bNina);

        Bundle bNiju = new Bundle();
        bNiju.putInt("image", R.drawable.bg_niju);
        bNiju.putString("name", "Ninu Junior");
        DemoParallaxFragment pfNiju = new DemoParallaxFragment();
        pfNiju.setArguments(bNiju);

        Bundle bYuki = new Bundle();
        bYuki.putInt("image", R.drawable.bg_yuki);
        bYuki.putString("name", "Yuki");
        DemoParallaxFragment pfYuki = new DemoParallaxFragment();
        pfYuki.setArguments(bYuki);

        Bundle bKero = new Bundle();
        bKero.putInt("image", R.drawable.bg_kero);
        bKero.putString("name", "Kero");
        DemoParallaxFragment pfKero = new DemoParallaxFragment();
        pfKero.setArguments(bKero);

        mAdapter.add(pfNina);
        mAdapter.add(pfNiju);
        mAdapter.add(pfYuki);
        mAdapter.add(pfKero);
        mPager.setAdapter(mAdapter);

        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
            getActionBar().show();
        }

        CirclePageIndicator mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setRadius(20);
        mIndicator.setViewPager(mPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();

        return super.onOptionsItemSelected(item);
    }
}
