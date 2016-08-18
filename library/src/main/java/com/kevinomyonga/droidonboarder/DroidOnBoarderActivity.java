package com.kevinomyonga.droidonboarder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.flyco.pageindicator.indicator.FlycoPageIndicaor;

import java.util.List;

/**
 * Created by Kevin Omyonga on 8/18/2016.
 */
public abstract class DroidOnBoarderActivity extends AppCompatActivity {

    protected LinearLayout background;
    protected ViewPager viewPager;
    protected Button btnSkip;
    protected Button btnNext;
    protected FlycoPageIndicaor indicator;

    FragmentStatePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        background = (LinearLayout)  findViewById(R.id.background);
        viewPager = (ViewPager) findViewById(R.id.viewpager) ;
        btnSkip = (Button) findViewById(R.id.btnSkip);
        btnNext = (Button) findViewById(R.id.btnNext);
        indicator = (FlycoPageIndicaor) findViewById(R.id.indicator_circle_stroke);

        // Color Customization
        background.setBackgroundColor(setBackgroundColor());
        btnSkip.setTextColor(setButtonTextColor());
        btnNext.setTextColor(setButtonTextColor());
        indicator.setStrokeColor(setIndicatorStrokeColor());
        indicator.setIndicatorSelectColor(setIndicatorSelectColor(), setIndicatorUnselectColor());

        setUpOnBoarder(populateOnBoarder());
    }

    /**
     *	Adds specified fragments to the OnBoarding UI.
     */
    protected abstract List<Fragment> populateOnBoarder();

    private void setUpOnBoarder(final List<Fragment> slides) {
        adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment f;

                f = slides.get(position);
                return f;
            }

            @Override
            public int getCount() {
                return slides.size();
            }
        };
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position == (slides.size() - 1)) {
                    btnSkip.setVisibility(View.GONE);
                    btnNext.setText(R.string.done);
                } else {
                    btnSkip.setVisibility(View.VISIBLE);
                    btnNext.setText(R.string.next);
                }
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishOnBoarding();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem() == (adapter.getCount() - 1)) {
                    finishOnBoarding();
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                }
            }
        });
    }

    /**
     *	Defines the background color for the UI.
     */
    protected abstract int setBackgroundColor();

    /**
     * Sets the text color for the Skip, Next and Done buttons used to navigate
     * through the UI.
     */
    protected abstract int setButtonTextColor();

    /**
     *	Sets the stroke color for the indicator.
     */
    protected abstract int setIndicatorStrokeColor();

    /**
     *	Set the color to be used when the an item in the indicator is selected.
     */
    protected abstract int setIndicatorSelectColor();

    /**
     *	Set the color to be used when the an item in the indicator is unselected.
     */
    protected abstract int setIndicatorUnselectColor();

    /**
     *	Defines tasks to be done once the OnBoarding is complete.
     */
    protected abstract void finishOnBoarding();
}
