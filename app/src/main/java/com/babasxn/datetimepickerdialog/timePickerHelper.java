package com.babasxn.datetimepickerdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class timePickerHelper extends DialogFragment {



    @Override

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {                               // if any of these shows an error just import the required methods
        Calendar mCalender = Calendar.getInstance();
        int hourOfDay=mCalender.get(Calendar.HOUR_OF_DAY);
        int minute=mCalender.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener)               // returns the TimePickerDialogFragment
                getActivity(), hourOfDay, minute, false );                                // is24hourView TRUE: changes the dialog box's clock, preferably use FALSE it's better

    }
}


