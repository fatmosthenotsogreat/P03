package sg.edu.rp.c346.id20028430.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GPACalculation extends AppCompatActivity {

    Button btnEnterGPA;
    Button btnShowGPA;
    Button btnUndo;
    Button btnReset;
    TextView displayGPA;
    EditText inputCAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_calculation);

        btnEnterGPA = findViewById(R.id.ButtonEnterGPA);
        btnShowGPA = findViewById(R.id.ButtonShowGPA);
        btnUndo = findViewById(R.id.ButtonUndo);
        btnReset = findViewById(R.id.ButtonReset);
        displayGPA = findViewById(R.id.DisplayGPA);
        inputCAG = findViewById(R.id.CAGGrade);

        ArrayList<String>cagList = new ArrayList<>();

        btnEnterGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputCAG.getText().toString().equals("A") || inputCAG.getText().toString().equals("B")
                        || inputCAG.getText().toString().equals("C") || inputCAG.getText().toString().equals("D")
                        || inputCAG.getText().toString().equals("F")) {
                    cagList.add(inputCAG.getText().toString());
                    inputCAG.getText().clear();
                    Toast.makeText(GPACalculation.this, "CAG Grade has been added", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(GPACalculation.this, "CAG Grade not available", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cagList.size() > 0) {
                    int index = cagList.size() -1;
                    cagList.remove(index);
                    Toast.makeText(GPACalculation.this, "Action has been undone", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(GPACalculation.this, "There are no CAG Grades added!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cagList.clear();
                Toast.makeText(GPACalculation.this, "All CAG Grades are removed", Toast.LENGTH_SHORT).show();
            }
        });
        btnShowGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double totalGPA = 0.00;
                for (int i = 0; i < cagList.size(); i++) {

                    //calculate gpa

                    if (cagList.get(i).equals("A")) {
                        totalGPA += 4;
                    }
                    else if (cagList.get(i).equals("B")) {
                        totalGPA += 3;
                    }
                    else if (cagList.get(i).equals("C")) {
                        totalGPA += 2;
                    }
                    else if (cagList.get(i).equals("D")) {
                        totalGPA += 1;
                    }
                    else {
                        totalGPA += 0;
                    }

                }

                double gpa;
                String message;
                String displayMessage = "";

                if (totalGPA == 0.0) {
                    gpa = 0.00;
                    displayMessage = "You have not entered any CAG Grades";
                }
                else {
                    gpa = totalGPA / cagList.size();

                    if (gpa >= 3) {
                        message = "Good work, keep it up!";
                    }
                    else if (gpa >= 2) {
                        message = "You can do better! Keep it up!";
                    }
                    else {
                        message = "Unlucky... Try harder!";
                    }
                    displayMessage = String.format("Your GPA is %.2f\n%s", gpa, message);
                }

                //display message
                displayGPA.setText(displayMessage);
            }
        });
    }
}