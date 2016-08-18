package com.kevinomyonga.droidonboarder.demo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLaunchIntro, btnGithub, btnFeedback, btnDonate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLaunchIntro = (Button) findViewById(R.id.btnLaunchIntro);
        btnGithub = (Button) findViewById(R.id.btnGithub);
        btnFeedback = (Button) findViewById(R.id.btnFeedback);
        btnDonate = (Button) findViewById(R.id.btnDonate);

        btnLaunchIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), AppIntroActivity.class));
            }
        });

        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(
                        "https://github.com/ImperiusRex/DroidOnBoarder")));
            }
        });

        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.intent.action.SENDTO",
                        Uri.fromParts("mailto", getString(R.string.app_author_email), null));
                i.putExtra("android.intent.extra.SUBJECT", "DroidOnBoarder Feedback");
                i.putExtra("android.intent.extra.TEXT", "Your feedback here...");
                startActivity(Intent.createChooser(i, "Send Feedback"));
            }
        });

        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri.Builder uriBuilder = new Uri.Builder();
                uriBuilder.scheme("https").authority("www.paypal.com").path("cgi-bin/webscr");
                uriBuilder.appendQueryParameter("cmd", "_donations");

                uriBuilder.appendQueryParameter("business", "komyonga@gmail.com");
                uriBuilder.appendQueryParameter("lc", "US");
                uriBuilder.appendQueryParameter("item_name", "Donation");
                uriBuilder.appendQueryParameter("no_note", "1");
                // uriBuilder.appendQueryParameter("no_note", "0");
                // uriBuilder.appendQueryParameter("cn", "Note to the developer");
                uriBuilder.appendQueryParameter("no_shipping", "1");
                uriBuilder.appendQueryParameter("currency_code", "USD");
                Uri payPalUri = uriBuilder.build();

                // Start your favorite browser
                Intent viewIntent = new Intent(Intent.ACTION_VIEW, payPalUri);
                startActivity(viewIntent);
            }
        });
    }
}
