package com.katza.ronapplication;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SharedPreference extends AppCompatActivity {

    private SharedPreferences sp;
    private Button btnOpenDialog;
    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_preference);

        // EdgeToEdge padding
        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        sp = getSharedPreferences("details1", MODE_PRIVATE);

        btnOpenDialog = findViewById(R.id.btnOpenDialog);
        tvDisplay = findViewById(R.id.tvDisplay);

        // הצגת שם אם כבר שמור
        String strfname = sp.getString("fname", null);
        String strlname = sp.getString("lname", null);
        if (strfname != null && strlname != null) {
            tvDisplay.setText("welcome " + strfname + " " + strlname);
        }

        btnOpenDialog.setOnClickListener(v -> openDialog());
    }

    private void openDialog() {
        // Inflate בטוח
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.costum_layout, null);

        EditText etFname = dialogView.findViewById(R.id.etDialogFname);
        EditText etLname = dialogView.findViewById(R.id.etDialogLname);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("הכנס שם ושם משפחה")
                .setView(dialogView)
                .setPositiveButton("שמור וסגור", null)
                .setNegativeButton("ביטול", (d, which) -> d.dismiss())
                .create();

        dialog.setOnShowListener(d -> {
            Button btnSave = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            btnSave.setOnClickListener(view -> {
                String fname = etFname.getText().toString().trim();
                String lname = etLname.getText().toString().trim();

                if (!fname.isEmpty() && !lname.isEmpty()) {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("fname", fname);
                    editor.putString("lname", lname);
                    editor.apply();

                    tvDisplay.setText("welcome " + fname + " " + lname);
                    dialog.dismiss();
                } else {
                    if (fname.isEmpty()) etFname.setError("יש להזין שם פרטי");
                    if (lname.isEmpty()) etLname.setError("יש להזין שם משפחה");
                }
            });
        });

        dialog.show();
    }
}
