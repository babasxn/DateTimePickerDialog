# DateTimePickerDialog
Tutorial on how to create a Date and Time Picker Dialog in Android Studio using Java


So I was working on a scheduler app (to be released soon) in which I had to add an UI utility where the user could easily add Date and Time to the record, rather than typing it which could cause inconsistencies in the database.

I searched it in the documentation, stackoverflow etc but there were complex/vague information for both the dialog fragments. I somehow combined few of the codes to make the helpers and support methods for both the dialog listeners. So here it is, Happy Developing!

# Source Codes

These are the main files you should check to implement these dialog fragments..

[Main Activity](/app/src/main/java/com/babasxn/datetimepickerdialog/MainActivity.java)

This contains the java code for the main activity where these fragments are located in form of image buttons in front of Date and Time EditText fields and their supporting methods.

[Date Picker Helper](/app/src/main/java/com/babasxn/datetimepickerdialog/datePickerHelper.java)

This contains the helper java code for the Date Picker Dialog Fragment which is later called in the main activity.

[Time Picker Helper](/app/src/main/java/com/babasxn/datetimepickerdialog/timePickerHelper.java)

This contains the helper java code for the Time Picker Dialog Fragment which is later called in the main activity.

[Main Activity XML](/app/src/main/res/layout/activity_main.xml)

This contains the XML attributes for the design and widgets. 

# Screenshots (Dark Mode)

Main Activity on startup

<img src="https://github.com/babasxn/DateTimePickerDialog/blob/master/mainActivityInitial.jpg" width="300">

Date Picker Dialog Fragment 

<img src="https://github.com/babasxn/DateTimePickerDialog/blob/master/datepickerDialog.jpg" width="300">

Time Picker Dialog Fragment 

<img src="https://github.com/babasxn/DateTimePickerDialog/blob/master/timepickerdialog.jpg" width="300">

Date and Time showing in the editText Fields after setting them through Dialog Fragments

<img src="https://github.com/babasxn/DateTimePickerDialog/blob/master/dateTime.jpg" width="300">

Main Activity after clicking on Show Button. Date and time are now showing in the TextView below the button.

<img src="https://github.com/babasxn/DateTimePickerDialog/blob/master/mainActivityFinal.jpg" width="300">





