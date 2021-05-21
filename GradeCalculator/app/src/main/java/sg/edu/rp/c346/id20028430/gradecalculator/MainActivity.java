package sg.edu.rp.c346.id20028430.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button gpaButton;
    Button cagButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gpaButton = findViewById(R.id.GPAButton);
        cagButton = findViewById(R.id.CAGButton);

        gpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GPACalculation.class);
                startActivity(intent);
            }
        });
        cagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CAGCalculation.class);
                startActivity(intent);
            }
        });
    }
}