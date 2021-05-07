package sg.edu.rp.c346.id20028430.practical1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText name;
    RadioGroup gender;
    ToggleButton subscription;
    Button signUp;
    TextView displayMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.NameField);
        gender = findViewById(R.id.RadioGenderGroup);
        subscription = findViewById(R.id.SubscriptionStatus);
        signUp = findViewById(R.id.SignUpButton);
        displayMessage = findViewById(R.id.SignUpButton);

        //set subscription status
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String output = "You are a " + subscriptionStatus;
                displayMessage.setText(output);
            }
        });

        subscription.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String subscriptionStatus;
                if (subscription.isChecked()) {
                    subscriptionStatus = "premium member";
                }
                else {
                    subscriptionStatus = "normal member";
                }

            }

        });




    }
}