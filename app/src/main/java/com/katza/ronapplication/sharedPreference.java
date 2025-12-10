package com.katza.ronapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sharedPreference extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences sp;
    Button btnSave;
    EditText etFname, etLname;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_preference);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sp = getSharedPreferences("details1", MODE_PRIVATE); // sp עכשיו מסוג SharedPreferences
        initViews();

        String strfname = sp.getString("fname", null);
        String strlname = sp.getString("lname", null);
        if (strlname != null && strfname != null) {
            tvDisplay.setText("welcome " + strfname + " " + strlname);
        }
    }

    private void initViews() {
        btnSave = findViewById(R.id.btnSubmit);
        etFname = findViewById(R.id.etFname);
        etLname = findViewById(R.id.etLname);
        tvDisplay = findViewById(R.id.tvDisplay);

        btnSave.setOnClickListener(this); // מאזין ללחיצה
    }

    @Override
    public void onClick(View v) {
        if (btnSave == v) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("fname", etFname.getText().toString());
            editor.putString("lname", etLname.getText().toString());
            editor.apply();

            tvDisplay.setText("welcome " + etFname.getText() + " " + etLname.getText());
        }
    }
}
