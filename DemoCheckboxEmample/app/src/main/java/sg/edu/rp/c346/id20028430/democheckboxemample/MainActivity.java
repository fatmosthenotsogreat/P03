package sg.edu.rp.c346.id20028430.democheckboxemample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cbEnabled;
        Button btnCheck;
        TextView tvShow;

        cbEnabled = findViewById(R.id.checkBoxDiscount);
        btnCheck = findViewById(R.id.buttonCheck);
        tvShow = findViewById(R.id.textView);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Button click", Toast.LENGTH_LONG).show();

                if (cbEnabled.isChecked()) {
                    tvShow.setText("Discount is given");
                }
                else {
                    tvShow.setText("Discount is not given");
                }
            }
        });


    }
}