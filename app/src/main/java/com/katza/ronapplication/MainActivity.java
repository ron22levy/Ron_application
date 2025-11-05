package com.katza.ronapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Switch switch2;
    private ImageView imageView3;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        switch2 = findViewById(R.id.switch2);
        imageView3 = findViewById(R.id.imageView3);
        seekBar = findViewById(R.id.seekBar);


        imageView3.setVisibility(ImageView.INVISIBLE);
        seekBar.setEnabled(false);


        switch2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageView3.setVisibility(ImageView.VISIBLE);
                seekBar.setEnabled(true); // מאפשר לשלוט בבהירות
            } else {
                imageView3.setVisibility(ImageView.INVISIBLE);
                seekBar.setEnabled(false); // מנטרל את השליטה בבהירות
            }
        });


        seekBar.setMax(100);
        seekBar.setProgress(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (switch2.isChecked()) {

                    float alpha = progress / 100f;
                    imageView3.setAlpha(alpha);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
