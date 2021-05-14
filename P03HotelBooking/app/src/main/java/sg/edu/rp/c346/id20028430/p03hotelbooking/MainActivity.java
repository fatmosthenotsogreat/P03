package sg.edu.rp.c346.id20028430.p03hotelbooking;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

import android70.widget.EditText;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    EditText fullName;
    EditText emailAddress;
    Spinner salutation;
    Spinner roomType;
    Button reservationDateButton;
    TextView displayRoomPrice;
    TextView displayGuestPax;
    TextView displayDate;
    TextView displayLength;
    EditText adult;
    EditText children;
    EditText lengthOfStay;
    Button update;
    TextView displayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullName = findViewById(R.id.FullName);
        emailAddress = findViewById(R.id.EmailAddress);
        salutation = findViewById(R.id.Salutation);
        reservationDateButton = findViewById(R.id.DateButton);
        roomType = findViewById(R.id.RoomType);
        displayRoomPrice = findViewById(R.id.RoomPriceDisplay);
        displayGuestPax = findViewById(R.id.GuestsDisplay);
        displayDate = findViewById(R.id.DateDisplay);
        displayLength = findViewById(R.id.LengthDisplay);
        adult = findViewById(R.id.AdultNumber);
        children = findViewById(R.id.ChildNumber);
        lengthOfStay = findViewById(R.id.LengthStay);
        update = findViewById(R.id.UpdateButton);
        displayName = findViewById(R.id.DisplayName);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.salutations, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        salutation.setAdapter(adapter1);
        salutation.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.room_type, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomType.setAdapter(adapter2);
        roomType.setOnItemSelectedListener(this);

        //date button
        reservationDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //display name
                String nameString = salutation.getSelectedItem().toString() + ". " + fullName.getText().toString();
                displayName.setText(nameString);

                //determine room price
                int adultCount;
                int childCount;
                int totalCount;

                if (TextUtils.isEmpty(adult.getText().toString()) || TextUtils.isEmpty(children.getText().toString())) {
                    adultCount = 0;
                    childCount = 0;
                }
                else {
                    adultCount = Integer.parseInt(adult.getText().toString());
                    childCount = Integer.parseInt(children.getText().toString());
                    totalCount = adultCount + childCount;

                    displayGuestPax.setText("Number of guests: " + totalCount);
                }

                //room price calculation
                int adultRoomPrice = 0;
                int childRoomPrice = 0;
                int stayLength;
                int totalPrice = 0;

                //check if length of stay is empty
                if (TextUtils.isEmpty(lengthOfStay.getText().toString())) {
                    displayLength.setText("Visiting for: Please enter length of stay.");
                }
                else {
                    stayLength = Integer.parseInt(lengthOfStay.getText().toString());
                    displayLength.setText("Visiting for: " + stayLength + " days");

                    if (roomType.getSelectedItem().toString().equalsIgnoreCase("Jailhouse")) {
                        childRoomPrice = 200 * childCount;
                        adultRoomPrice = 300 * adultCount;

                        totalPrice = (childRoomPrice + adultRoomPrice) * stayLength;
                        displayRoomPrice.setText("Room Price: $" + totalPrice);
                    }
                    else if (roomType.getSelectedItem().toString().equalsIgnoreCase("Peasant Room")) {
                        childRoomPrice = 250 * childCount;
                        adultRoomPrice = 350 * adultCount;

                        totalPrice = (childRoomPrice + adultRoomPrice) * stayLength;
                        displayRoomPrice.setText("Room Price: $" + totalPrice);
                    }
                    else if (roomType.getSelectedItem().toString().equalsIgnoreCase("Better-off Suite")) {
                        childRoomPrice = 350 * childCount;
                        adultRoomPrice = 450 * adultCount;

                        totalPrice = (childRoomPrice + adultRoomPrice) * stayLength;
                        displayRoomPrice.setText("Room Price: $" + totalPrice);
                    }
                    else {
                        childRoomPrice = 500 * childCount;
                        adultRoomPrice = 650 * adultCount;

                        totalPrice = (childRoomPrice + adultRoomPrice) * stayLength;
                        displayRoomPrice.setText("Room Price: $" + totalPrice);
                    }


                }

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        displayDate.setText("Visiting On: " + currentDateString);
    }

}