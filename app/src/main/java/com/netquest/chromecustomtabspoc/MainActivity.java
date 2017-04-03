package com.netquest.chromecustomtabspoc;

import android.graphics.Color;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button goButton = (Button)findViewById(R.id.goButton);
		goButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Uri uri = Uri.parse("https://jgonfer.com/nicequest/deep_linking.php");

				// create an intent builder
				CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();

				// Begin customizing
				// set toolbar colors
				intentBuilder.setToolbarColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
				intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));

				// set start and exit animations
				intentBuilder.setStartAnimations(MainActivity.this, R.anim.slide_in_right, R.anim.slide_out_left);
				intentBuilder.setExitAnimations(MainActivity.this, android.R.anim.slide_in_left,
						android.R.anim.slide_out_right);

				// build custom tabs intent
				CustomTabsIntent customTabsIntent = intentBuilder.build();

				// launch the url
				customTabsIntent.launchUrl(MainActivity.this, uri);
			}
		});
	}
}
