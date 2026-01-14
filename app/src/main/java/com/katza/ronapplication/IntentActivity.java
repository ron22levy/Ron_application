package com.katza.ronapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        // --- לוגיקה של השאלון ---

        // חיבור הרכיבים מה-XML
        EditText et1 = findViewById(R.id.et_q1);
        EditText et2 = findViewById(R.id.et_q2);
        EditText et3 = findViewById(R.id.et_q3);
        // השדה החדש של הכסף (תוודא שה-ID הזה קיים ב-XML שלך)
        EditText etMoney = findViewById(R.id.et_money);
        Button btn = findViewById(R.id.btn_send);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // יצירת Intent למעבר לדף התוצאות
                Intent intent = new Intent(IntentActivity.this, SummaryActivity.class);

                // הוספת הנתונים שהמשתמש הקליד
                intent.putExtra("VAL1", et1.getText().toString());
                intent.putExtra("VAL2", et2.getText().toString());
                intent.putExtra("VAL3", et3.getText().toString());

                // הוספת השקלים למעבר לדף הבא
                intent.putExtra("SHEKELS", etMoney.getText().toString());

                // הפעלת המעבר
                startActivity(intent);
            }
        });
    }

    // --- לוגיקה של התפריט (Menu) ---

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
            Intent intent = new Intent(this, DynamicActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_Main) {
            Toast.makeText(this, "Main clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_SP) {
            Toast.makeText(this, "SP clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SharedPreference.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_Intent) {
            Toast.makeText(this, "Intent Activity clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, IntentActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}