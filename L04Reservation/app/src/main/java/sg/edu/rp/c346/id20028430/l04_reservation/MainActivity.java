package sg.edu.rp.c346.id20028430.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    EditText firstName;
    EditText lastName;
    EditText mobile;
    EditText groupSize;
    EditText discountCode;
    RadioGroup tableType;
    RadioButton selectedTableType;
    Button dateButton;
    Button timeButton;
    Button submitButton;
    Button resetButton;
    TextView reviewHeader;
    TextView nameDisplay;
    TextView mobileDisplay;
    TextView groupSizeDisplay;
    TextView tableTypeDisplay;
    TextView dateOfReservationDisplay;
    TextView timeOfReservationDisplay;
    TextView discountDisplay;

    String date = "Monday, 1 June 2020";
    String time = "19:30";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.FirstName);
        lastName = findViewById(R.id.LastName);
        mobile = findViewById(R.id.MobileNumber);
        groupSize = findViewById(R.id.GroupSize);
        discountCode = findViewById(R.id.DiscountCode);
        tableType = findViewById(R.id.TableType);
        dateButton = findViewById(R.id.DateButton);
        timeButton = findViewById(R.id.TimeButton);
        submitButton = findViewById(R.id.SubmitButton);
        resetButton = findViewById(R.id.ResetButton);
        reviewHeader = findViewById(R.id.ReviewHeader);
        nameDisplay = findViewById(R.id.NameDisplay);
        mobileDisplay = findViewById(R.id.MobileDisplay);
        groupSizeDisplay = findViewById(R.id.GroupSizeDisplay);
        tableTypeDisplay = findViewById(R.id.TableTypeDisplay);
        dateOfReservationDisplay = findViewById(R.id.DateDisplay);
        timeOfReservationDisplay = findViewById(R.id.TimeDisplay);
        discountDisplay = findViewById(R.id.DiscountDisplay);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(firstName.getText().toString()) ||
                        TextUtils.isEmpty(lastName.getText().toString()) ||
                            TextUtils.isEmpty(mobile.getText().toString()) ||
                                TextUtils.isEmpty(groupSize.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Fill all necessary information before proceeding", Toast.LENGTH_LONG).show();
                }
                else {
                    String name = firstName.getText() + " " + lastName.getText();

                    int radioId = tableType.getCheckedRadioButtonId();
                    selectedTableType = findViewById(radioId);

                    String discount;

                    if (discountCode.getText().toString().equals("Give Amos an A")) {
                        discount = "10%";
                    }
                    else {
                        discount = "0%";
                    }

                    reviewHeader.setText("Order Review");
                    nameDisplay.setText("Name of Guest " + name);
                    mobileDisplay.setText("Contact number: +65 " + mobile.getText());
                    groupSizeDisplay.setText("Group size: " + groupSize.getText());
                    tableTypeDisplay.setText("Table Type: " + selectedTableType.getText());
                    dateOfReservationDisplay.setText("Date of Reservation: " + date);
                    timeOfReservationDisplay.setText("Time of Reservation: " + time);
                    discountDisplay.setText("Discount: " + discount);

                }
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName.getText().clear();
                lastName.getText().clear();
                mobile.getText().clear();
                groupSize.getText().clear();
                discountCode.getText().clear();
            }
        });
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String placeholder = Integer.toString(hourOfDay) + Integer.toString(minute);
        int timeInt = Integer.parseInt(placeholder);

        String timeString = hourOfDay + ":" + minute;

        if (timeInt < 759 || timeInt > 2100) {
            Toast.makeText(MainActivity.this, "Opening hours is from 0800 hours to 0859 hours", Toast.LENGTH_LONG).show();
        }
        else {
            time = timeString;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String dateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        date = dateString;
    }
}