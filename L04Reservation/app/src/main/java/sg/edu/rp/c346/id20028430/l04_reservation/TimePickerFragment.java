package sg.edu.rp.c346.id20028430.l04_reservation;

import android.app.TimePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {
    @NonNull
    @Override

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        int hour = 19;
        int minute = 30;

        return new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) getActivity(), hour, minute, true);
    }
}