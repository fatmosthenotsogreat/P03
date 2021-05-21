package sg.edu.rp.c346.id20028430.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CAGCalculation extends AppCompatActivity {

    ToggleButton btnRubrics;
    Button btnCalculate;
    Button btnReset;
    EditText aks;
    EditText sdl;
    EditText col;
    TextView tvCAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cag_calculation);

        btnRubrics = findViewById(R.id.ButtonRubrics);
        btnCalculate = findViewById(R.id.ButtonSubmit);
        btnReset = findViewById(R.id.ButtonCAGReset);
        aks = findViewById(R.id.AKSInput);
        sdl = findViewById(R.id.SDLInput);
        col = findViewById(R.id.COLInput);
        tvCAG = findViewById(R.id.DisplayCAG);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aks.getText().clear();
                sdl.getText().clear();
                col.getText().clear();
                tvCAG.setText("");
            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double totalPoints = 0;

                if (aks.getText().toString().isEmpty() || sdl.getText().toString().isEmpty() ||
                        col.getText().toString().isEmpty()) {
                    Toast.makeText(CAGCalculation.this, "Please fill in all the values", Toast.LENGTH_SHORT).show();
                }
                else if (Integer.parseInt(aks.getText().toString()) < 1 || Integer.parseInt(aks.getText().toString()) > 4
                        || Integer.parseInt(sdl.getText().toString()) < 1 || Integer.parseInt(sdl.getText().toString()) > 4
                        || Integer.parseInt(col.getText().toString()) < 1 || Integer.parseInt(col.getText().toString()) > 4) {
                    Toast.makeText(CAGCalculation.this, "Please keep the values between 1 to 4", Toast.LENGTH_SHORT).show();
                }
                else {

                    if (btnRubrics.isChecked()) {
                        totalPoints += Double.parseDouble(aks.getText().toString()) * 0.5;
                        totalPoints += Double.parseDouble(sdl.getText().toString()) * 0.25;
                        totalPoints += Double.parseDouble(col.getText().toString()) * 0.25;
                    }
                    else {
                        totalPoints += Double.parseDouble(aks.getText().toString()) * 0.6;
                        totalPoints += Double.parseDouble(sdl.getText().toString()) * 0.2;
                        totalPoints += Double.parseDouble(col.getText().toString()) * 0.2;
                    }

                    double percent = (totalPoints / 4) * 100;
                    String grade;

                    if (percent < 50) {
                        grade = "F";
                    }
                    else if (percent < 60) {
                        grade = "D";
                    }
                    else if (percent < 70) {
                        grade = "C";
                    }
                    else if (percent < 80) {
                        grade = "B";
                    }
                    else {
                        grade = "A";
                    }

                    //message
                    String message;
                    if (grade.equals("A")) {
                        message = "Give Amos this one.";
                    }
                    else if (grade.equals("B")) {
                        message = "Can sometimes give Amos this one.";
                    }
                    else if (grade.equals("C")) {
                        message = "Avoid giving Amos this one.";
                    }
                    else if (grade.equals("D")) {
                        message = "Don't give Amos this one.";
                    }
                    else {
                        message = "Amos is smarter than this.";
                    }

                    String output = String.format("The CAG grade is %s.\n%s",grade, message);
                    tvCAG.setText(output);
                }
            }
        });
    }
}