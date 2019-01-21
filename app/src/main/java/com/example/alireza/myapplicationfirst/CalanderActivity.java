package com.example.alireza.myapplicationfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

public class CalanderActivity extends AppCompatActivity {


    TextView showDate;
    CalendarView myCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander);

        showDate = (TextView) findViewById(R.id.showDateTxt);
        myCalendarView = (CalendarView) findViewById(R.id.CalanderView1);

        myCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                String date = year + "/" + month + "/" + dayOfMonth;
                showDate.setText(date);

            }
        });
    }
}
