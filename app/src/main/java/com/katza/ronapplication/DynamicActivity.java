package com.katza.ronapplication;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DynamicActivity extends AppCompatActivity {

    LinearLayout llm;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dynamic);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        llm = findViewById(R.id.main);

        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
        LinearLayout.LayoutParams hsParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        horizontalScrollView.setLayoutParams(hsParams);

        LinearLayout llScroll = new LinearLayout(this);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llScroll.setLayoutParams(llParams);
        llScroll.setOrientation(LinearLayout.HORIZONTAL);


        for (int i = 1; i<=100; i++){

            imageView = new ImageView(this);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200,200);
            layoutParams.setMargins(10,10,10,10);
            imageView.setLayoutParams(layoutParams);
            int imageKey = getResources().getIdentifier("img_" + i%3,"drawable",getPackageName());
            imageView.setImageResource(imageKey);
            // linearLayout.addView(imageView);
            llScroll.addView(imageView);

        }

        horizontalScrollView.addView(llScroll);

        llm.addView(horizontalScrollView);

        //עולה לאורך

        ScrollView verticalScrollView = new ScrollView(this);
        LinearLayout.LayoutParams vsParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        verticalScrollView.setLayoutParams(vsParams);

        LinearLayout llVertical = new LinearLayout(this);
        LinearLayout.LayoutParams llVParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        llVertical.setLayoutParams(llVParams);
        llVertical.setOrientation(LinearLayout.VERTICAL);

        for (int i = 1; i <= 100; i++) {

            ImageView iv = new ImageView(this);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200, 200);
            layoutParams.setMargins(10, 10, 10, 10);
            iv.setLayoutParams(layoutParams);

            int imgRes = getResources().getIdentifier("img_" + (i % 3), "drawable", getPackageName());
            iv.setImageResource(imgRes);

            llVertical.addView(iv);
        }

        verticalScrollView.addView(llVertical);

        llm.addView(verticalScrollView);

    }
}