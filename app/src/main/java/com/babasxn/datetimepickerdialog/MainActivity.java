package com.babasxn.datetimepickerdialog;



import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import java.util.Calendar;

import static android.widget.Toast.LENGTH_SHORT;

/* don't forget to implement the listeners. It might show an error at first if you simply ctrl+c/v the support methods
so first implement the methods (alt+enter on listeners) and then paste their content.
 */
public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    // declaring the required objects

    EditText editTime, editDate;
    TextView textDateShow, textTimeShow, textTimePick, textDatePick;
    ImageButton buttonDatePick, buttonTimePick;
    Button buttonShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //relating the objects to their respective xml design widgets
        editTime= (EditText) findViewById(R.id.editTime);
        editDate= (EditText) findViewById(R.id.editDate);

        textDateShow= (TextView) findViewById(R.id.textViewDateShow);
        textDatePick= (TextView) findViewById(R.id.textViewDatePick);
        textTimePick= (TextView) findViewById(R.id.textViewTimePick);
        textTimeShow= (TextView) findViewById(R.id.textViewTimeShow);

        buttonDatePick= (ImageButton) findViewById(R.id.imageButtonDate);
        buttonTimePick= (ImageButton) findViewById(R.id.imageButtonTime);

        buttonShow= (Button) findViewById(R.id.buttonShow);


                                                                                                     //Date Picker Image Button On Click Function launches a dialog box with calling the supporting function OnDateSet (see below)
        buttonDatePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.babasxn.datetimepickerdialog.datePickerHelper mDatePickerDialogFragment;         //creates a dialog fragment with the help of datePickerHelper.java
                mDatePickerDialogFragment = new com.babasxn.datetimepickerdialog.datePickerHelper(); //allocates memory for dialog box
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");        //shows the dialog box and calls OnDateSet


            }
        });



        buttonTimePick.setOnClickListener(new View.OnClickListener() {                                //Time Picker Image Button On Click Function launches a dialog box with calling the supporting function OnTimeSet (see below)
            @Override
            public void onClick(View v) {
                com.babasxn.datetimepickerdialog.timePickerHelper mTimePickerDialogFragment;         // creates a dialog fragment with the help of timePickerHelper.java
                mTimePickerDialogFragment = new com.babasxn.datetimepickerdialog.timePickerHelper(); // allocates memory for dialog box
                mTimePickerDialogFragment.show(getSupportFragmentManager(), "TIME PICK");       // shows the dialog box and calls OnTimeSet
            }
        });


                                                                                                     //Show Button On Click Function gets the text from Date/Time EditTexts and sets it on the textViews at the bottom
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date=editDate.getText().toString();
                String time=editTime.getText().toString();

                textDateShow.setText(date);
                textTimeShow.setText(time);

                Toast.makeText(MainActivity.this, "Done", LENGTH_SHORT).show();

                editDate.setText("");
                editTime.setText("");

            }
        });

    }




    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {                        // support method for DatePickerDialogFragment
        Calendar mCalender = Calendar.getInstance();
        mCalender.set(Calendar.YEAR, year);                                                              //gets Year, Month and Date from java.util.Calendar
        mCalender.set(Calendar.MONTH, month);
        mCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String selectedDate= dayOfMonth + "/" + (month+1) + "/" + year;                                // month+1 because java.util.Calender.MONTH starts from 0 so like January is 0 instead of 1
        editDate.setText(selectedDate);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {                                // support method for TimePickerDialogFragment
        String ampm;
        Calendar mCalender = Calendar.getInstance();                                                   //gets Hour and Minute from java.util.Calendar
        mCalender.set(Calendar.HOUR_OF_DAY,hourOfDay);
        mCalender.set(Calendar.MINUTE,minute);

        String selectedTime;

        if (hourOfDay>12){                                                                            // to set AM & PM as calling the ampm method is lil bit complicated (not required when is24HourView is set to True)
            ampm=" PM";
            hourOfDay=hourOfDay-12;
        }


        else
            ampm=" AM";

        if(minute<9)                                                                                 // to add a 0 prefix for single digit minutes (for ex earlier it was 1:9PM instead of 1:09PM)
            selectedTime  = hourOfDay + ":0" +minute +ampm;

        else
            selectedTime  = hourOfDay + ":" +minute +ampm;

        editTime.setText(selectedTime);


    }
}

