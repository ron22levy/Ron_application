package com.katza.ronapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // חיבור הרכיבים מה-XML
        TextView tv1 = findViewById(R.id.tv_res1);
        TextView tv2 = findViewById(R.id.tv_res2);
        TextView tv3 = findViewById(R.id.tv_res3);
        // וודא שב-XML יש TextView עם ה-ID הזה לתוצאה בדולרים
        TextView tvDollars = findViewById(R.id.tv_res_dollars);
        Button btnBack = findViewById(R.id.btn_back_home);

        // קבלת האינטנט והנתונים שנשלחו מה-IntentActivity
        Intent intent = getIntent();
        String a1 = intent.getStringExtra("VAL1");
        String a2 = intent.getStringExtra("VAL2");
        String a3 = intent.getStringExtra("VAL3");
        String shekelsStr = intent.getStringExtra("SHEKELS");

        // הצגת הנתונים הטקסטואליים
        tv1.setText("שם: " + a1);
        tv2.setText("מקצוע: " + a2);
        tv3.setText("מגורים: " + a3);

        // --- לוגיקת החישוב לדולרים ---
        if (shekelsStr != null && !shekelsStr.isEmpty()) {
            try {
                double shekels = Double.parseDouble(shekelsStr);
                double dollars = shekels / 3.7; // חישוב לפי שער המרה 3.7

                // עיגול התוצאה ל-2 ספרות אחרי הנקודה
                String formattedResult = String.format("%.2f", dollars);
                tvDollars.setText("הסכום בדולרים: $" + formattedResult);
            } catch (NumberFormatException e) {
                // במקרה שהמשתמש הזין משהו שאינו מספר
                tvDollars.setText("שגיאה בחישוב הסכום");
            }
        }

        // כפתור חזרה לדף הקודם (השאלון)
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}