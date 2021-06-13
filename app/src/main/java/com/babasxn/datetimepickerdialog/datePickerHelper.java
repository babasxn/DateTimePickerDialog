package com.babasxn.datetimepickerdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

public class datePickerHelper extends DialogFragment {

    @Override

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {                              // if any of these shows an error just import the required methods

        Calendar mCalender = Calendar.getInstance();
        int year = mCalender.get(Calendar.YEAR);
        int month = mCalender.get(Calendar.MONTH);
        int dayOfMonth = mCalender.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener)               // returns the DatePickerDialogFragment
                getActivity(), year, month, dayOfMonth);
    }

}