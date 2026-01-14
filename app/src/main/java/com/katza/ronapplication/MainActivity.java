package com.katza.ronapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Switch switch2;
    private ImageView imageView3;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Setup Toolbar
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setTitle("Ron Application");
//        }

        // 2. Link UI Elements
        switch2 = findViewById(R.id.switch2);
        imageView3 = findViewById(R.id.imageView3);
        seekBar = findViewById(R.id.seekBar);

        // 3. Initial State
        imageView3.setVisibility(ImageView.INVISIBLE);
        seekBar.setEnabled(false);
        seekBar.setMax(100);
        seekBar.setProgress(100);

        // 4. Switch Listener
        switch2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageView3.setVisibility(ImageView.VISIBLE);
                seekBar.setEnabled(true);
            } else {
                imageView3.setVisibility(ImageView.INVISIBLE);
                seekBar.setEnabled(false);
            }
        });

        // 5. SeekBar Listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float alpha = progress / 100f;
                imageView3.setAlpha(alpha);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_Dynamic) {
            Toast.makeText(this, "Dynamic clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,DynamicActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_Main) {
            Toast.makeText(this, "Main clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_SP) {
            Toast.makeText(this, "SP clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,SharedPreference.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_Intent) {
            Toast.makeText(this, "מעבר לשאלון", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, IntentActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}