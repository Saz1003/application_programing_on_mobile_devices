package com.example.week_3;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivity extends AppCompatActivity {

    private EditText editTextCorrected;
    private Button buttonSubmitBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        editTextCorrected = findViewById(R.id.edit_corrected);
        buttonSubmitBack = findViewById(R.id.btn_submit_back);

        String studentText = getIntent().getStringExtra("student_text");
        editTextCorrected.setText(studentText);

        buttonSubmitBack.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("corrected_text", editTextCorrected.getText().toString());
            setResult(88, resultIntent);
            finish();
        });
    }
}