package com.example.quadratic_equation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
    TextView txt_result, txt_equation;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Ánh xạ id
        txt_result = findViewById(R.id.txt_result);
        txt_equation = findViewById(R.id.txt_equation);
        btn_back = findViewById(R.id.btn_back);

        // Nhận Intent và Bundle
        Intent myintent = getIntent();
        Bundle mybundle = myintent.getBundleExtra("mypackage");
        Double a = mybundle.getDouble("a");
        Double b = mybundle.getDouble("b");
        Double c = mybundle.getDouble("c");
        DecimalFormat dcf = new DecimalFormat("0.00");
        txt_equation.setText(a + "x² + " + b +"x + " + c);
        // Giải phương trình bậc 2
        if (a == 0) {
            // Nếu a = 0, chuyển về phương trình bậc nhất
            if (b != 0) {
                double x = -c / b;
                txt_result.setText("Phương trình trở thành bậc nhất: x = " + dcf.format(x));
            } else {
                if (c == 0) {
                    txt_result.setText("Vô số nghiệm");
                } else {
                    txt_result.setText("Phương trình vô nghiệm");
                }
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                txt_result.setText("Phương trình vô nghiệm");
            } else if (delta == 0) {
                double x = -b / (2.0 * a);
                txt_result.setText("x1 = x2 = " + dcf.format(x));
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2.0 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2.0 * a);
                txt_result.setText("x1 = " + dcf.format(x1) + "\nx2 = " + dcf.format(x2));
            }
        }

        // Xử lý sự kiện nút "Back" để trở về Activity trước đó
        btn_back.setOnClickListener(v -> finish());
    }
}
