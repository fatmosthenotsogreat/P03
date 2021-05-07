package sg.edu.rp.c346.id20028430.p03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    Button btnDisplay;
    EditText etInput;
    ToggleButton tbtn;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvDisplay = findViewById(R.id.textViewDisplay);
        btnDisplay = findViewById(R.id.buttonDisplay);
        etInput = findViewById(R.id.editTextInput);
        tbtn = findViewById(R.id.toggleButtonEnabled);
        rgGender = findViewById(R.id.radioGroupGender);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strResponse = etInput.getText().toString();
                int checkedRadioId = rgGender.getCheckedRadioButtonId();

                if (checkedRadioId == R.id.radioButtonGenderMale) {
                    strResponse = "He says: " + strResponse;
                }
                else {
                    strResponse = "She says: " + strResponse;
                }
                tvDisplay.setText(strResponse);
            }
        });

        tbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (tbtn.isChecked()) {
                    etInput.setEnabled(true);
                }
                else {
                    etInput.setEnabled(false);
                }
            }
        });


    }
}