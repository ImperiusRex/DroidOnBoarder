# DroidOnBoarder
A library designed to help you create an OnBoarding/Intro UI in your android app with ease.

## Demo
Try out the app here: 

 [DroidOnBoarder APK](https://github.com/ImperiusRex/DroidOnBoarder/blob/master/app/DroidOnBoarder_1.0.0.apk)

### Screenshots
![ScreenShot](https://raw.github.com/ImperiusRex/DroidOnBoarder/master/screenshots/sample1.png)
![ScreenShot](https://raw.github.com/ImperiusRex/DroidOnBoarder/master/screenshots/sample2.png)
![ScreenShot](https://raw.github.com/ImperiusRex/DroidOnBoarder/master/screenshots/sample3.png)


##Target Platforms
Android API level 9 or later.


## Setup
### 1. Provide the gradle dependency
```Java
dependencies {
    compile 'com.kevinomyonga.droidonboarder:library:1.0.0'
}
```

### 2. Create your Intro Activity that extends DroidOnBoarderActivity 
```Java
public class AppIntroActivity extends DroidOnBoarderActivity {}
```

### 3. Implement the populateOnBoarder() function to add fragments/pages to the UI. 
You can use the preset DroidOnBoarderFragment to specify the data to be displayed on each fragment i.e.
1. The image to be dispalyed.
2. Title Text
3. Body Text
4. Title Text Color
5. Body Text Color
```Java
public class AppIntroActivity extends DroidOnBoarderActivity {

    @Override
    protected List<Fragment> populateOnBoarder() {

        // Create slides using the default fragment with the preset parameters
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
}
```

Or if you prefer, define your own fragment or fragments and add them to the UI.
```Java
public class AppIntroActivity extends DroidOnBoarderActivity {

    @Override
    protected List<Fragment> populateOnBoarder() {

        // You can also add your own custom fragments
        List<Fragment> introSlides = new ArrayList<>();
        introSlides.add(MyFragment1.newInstance());
        introSlides.add(MyFragment2.newInstance());
        introSlides.add(MyFragment3.newInstance());
        introSlides.add(MyFragment4.newInstance());

        return introSlides;
    }
}
```

### 4. Customize the look of the UI.
```Java
public class AppIntroActivity extends DroidOnBoarderActivity {

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
}
```

### 5. Specify what is to be happen once the Intro is done or if the user chooses to skip it.
```Java
public class AppIntroActivity extends DroidOnBoarderActivity {

    @Override
    protected void finishOnBoarding() {
        //Close Activity
        finish();
    }
}
```

### 6. Remove the actionbar and declare in the manifest.
Go to the styles.xml file in the res/values folder and add this code. (If you don't already have it)
```XML
    <style name="AppTheme.NoActionBar">
        <item name="windowActionBar">false</item>
        <item name="windowNoTitle">true</item>
    </style>
```

Add the Intro activity to the manifest.
```XML
    <activity android:name=".AppIntroActivity"
        android:theme="@style/AppTheme.NoActionBar" />
```

Now you're good to go.

## Libraries Used
* [FlycoPageIndicator](https://github.com/H07000223/FlycoPageIndicator)
* [NineOldAndroids](https://github.com/JakeWharton/NineOldAndroids)


## License
This project is licensed under the Apache License - see the [LICENSE](https://raw.github.com/ImperiusRex/DroidOnBoarder/master/LICENSE) file for details.
