package com.example.user.busticket;


import android.app.DatePickerDialog;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Booking extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private String[] mFullDayNames;
    private String[] mShortDayNames;
    private boolean mWeekStartsOnMonday;
    private boolean m24hClock;
    private SimpleDateFormat mTimeFormat;
    private SimpleDateFormat mDateFormat;
    Button b1;
    TextView t1,t2;
    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking);
        t1 = (TextView) findViewById(R.id.textView10);
        t2 = (TextView) findViewById(R.id.textView12);
        btnDatePicker=(Button)findViewById(R.id.button5);
        btnTimePicker=(Button)findViewById(R.id.button6);
        txtDate=(EditText)findViewById(R.id.editText6);
        txtTime=(EditText)findViewById(R.id.editText7);

             btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);

        final Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {
            String s = (String) bd.get("a");
            t1.setText(s);
            String n = (String) bd.get("aa");
            t2.setText(n);
        } else {
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Booking.this, Bus.class);
                startActivity(i);
            }
        });
    }



    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }


}