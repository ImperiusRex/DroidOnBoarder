package com.kevinomyonga.droidonboarder.demo;

import android.graphics.Color;
import android.support.v4.app.Fragment;

import com.kevinomyonga.droidonboarder.DroidOnBoarderActivity;
import com.kevinomyonga.droidonboarder.DroidOnBoarderFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Omyonga on 8/18/2016.
 */
public class AppIntroActivity extends DroidOnBoarderActivity {

    @Override
    protected List<Fragment> populateOnBoarder() {

        // Create slides using the default fragment with the preset parameters
        // You can also add your own custom fragments
        List<Fragment> introSlides = new ArrayList<>();
        introSlides.add(DroidOnBoarderFragment
                .newInstance(R.mipmap.ic_launcher, "Title 1", "Description 1", Color.WHITE, Color.WHITE));
        introSlides.add(DroidOnBoarderFragment
                .newInstance(R.mipmap.ic_launcher, "Title 2", "Description 2", Color.YELLOW, Color.YELLOW));
        introSlides.add(DroidOnBoarderFragment
                .newInstance(R.mipmap.ic_launcher, "Title 3", "Description 3", Color.BLACK, Color.BLACK));
        introSlides.add(DroidOnBoarderFragment
                .newInstance(R.mipmap.ic_launcher, "Title 4", "Description 4", Color.RED, Color.RED));

        return introSlides;
    }

    @Override
    protected int setBackgroundColor() {
        return getResources().getColor(R.color.colorPrimary);
    }

    @Override
    protected int setButtonTextColor() {
        return getResources().getColor(R.color.colorAccent);
    }

    @Override
    protected int setIndicatorStrokeColor() {
        return Color.WHITE;
    }

    @Override
    protected int setIndicatorSelectColor() {
        return Color.WHITE;
    }

    @Override
    protected int setIndicatorUnselectColor() {
        return Color.TRANSPARENT;
    }

    @Override
    protected void finishOnBoarding() {
        //Close Activity
        finish();
    }
}
