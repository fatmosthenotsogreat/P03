package sg.edu.rp.c346.id20028430.passcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvAddition;
    TextView tvSubtraction;
    TextView tvMultiplication;
    TextView tvDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvAddition = findViewById(R.id.textViewAddition);
        tvSubtraction = findViewById(R.id.textViewSubtraction);
        tvMultiplication = findViewById(R.id.textViewMultiplication);
        tvDivision = findViewById(R.id.textViewDivision);

        Intent intentReceived = getIntent();
        double num1 = intentReceived.getDoubleExtra("num1", 0.0);
        double num2 = intentReceived.getDoubleExtra("num2", 0.0);

        String addition = String.format("%.2f",num1 + num2);
        String subtraction = String.format("%.2f",num1 - num2);
        String multiplication = String.format("%.2f",num1 * num2);
        String division = String.format("%.2f",num1 / num2);

        tvAddition.setText(addition);
        tvSubtraction.setText(subtraction);
        tvMultiplication.setText(multiplication);
        tvDivision.setText(division);
    }
}