package com.kevinomyonga.droidonboarder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kevin Omyonga on 8/18/2016.
 */
public class DroidOnBoarderFragment extends Fragment {

    public static final String KEY_IMAGE = "KEY_IMAGE", KEY_TITLE = "KEY_TITLE",
            KEY_BODY = "KEY_BODY", KEY_TITLE_COLOR = "KEY_TITLE_COLOR",
            KEY_BODY_COLOR = "KEY_BODY_COLOR";

    int image;
    String title, body;

    ImageView imageView;
    TextView txtTitle, txtBody;
    private int titleTextColor;
    private int bodyTextColor;

    public DroidOnBoarderFragment() {}

    /**
     * @param image the image drawable to be used in the fragment
     * @param title the title to be used in the fragment
     * @param body the body to be used in the fragment
     * @param titleTextColor the color to be used for the title in the fragment
     * @param bodyTextColor the color to be used for the body in the fragment
     */
    public static DroidOnBoarderFragment newInstance(int image, String title, String body,
                                                     int titleTextColor, int bodyTextColor) {
        DroidOnBoarderFragment f = new DroidOnBoarderFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_IMAGE, image);
        args.putString(KEY_TITLE, title);
        args.putString(KEY_BODY, body);
        args.putInt(KEY_TITLE_COLOR, titleTextColor);
        args.putInt(KEY_BODY_COLOR, bodyTextColor);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            image = args.getInt(KEY_IMAGE);
            title = args.getString(KEY_TITLE);
            body = args.getString(KEY_BODY);
            titleTextColor = args.getInt(KEY_TITLE_COLOR);
            bodyTextColor = args.getInt(KEY_BODY_COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_onboarding, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtBody = (TextView) view.findViewById(R.id.txtBody);

        txtTitle.setTextColor(titleTextColor);
        txtBody.setTextColor(bodyTextColor);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView.setImageResource(image);
        txtTitle.setText(title);
        txtBody.setText(body);
    }
}
