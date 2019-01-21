package com.example.alireza.myapplicationfirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalanderActivity extends AppCompatActivity {


    TextView showDate;
    CalendarView myCalendarView;
    Button submitBtnCal;
    String year1, month1, day1;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander);

        showDate = (TextView) findViewById(R.id.showDateTxt);
        myCalendarView = (CalendarView) findViewById(R.id.CalanderView1);
        submitBtnCal = (Button) findViewById(R.id.saveDateBtn);

        myCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                 date = year + "/" + (month + 1) + "/" + dayOfMonth;
                 year1 = Integer.toString(year);
                 month1 = Integer.toString((month + 1));
                 day1 = Integer.toString(dayOfMonth);

                submitBtnCal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent tolListByCal = new Intent(getApplicationContext(), MainActivity.class);
                        MainActivity.prepareData(new Task("calander",date, year1, month1, day1));
                        startActivity(tolListByCal);
                    }
                });


            }
        });
    }
}
