package com.example.alireza.myapplicationfirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    EditText taskInfo;
    EditText taskYear;
    EditText taskMonth;
    EditText taskDay;
    EditText taskHour;
    EditText taskMinute;
    EditText taskSecond;
    Button submitBtn;
    Button toCalender;

    public boolean checkDatesEnterd(EditText year, EditText month, EditText day, EditText hour, EditText minute, EditText second){
        if (year.getText().toString().equals("")  && month.getText().toString().equals("")  && day.getText().toString().equals("")
                && hour.getText().toString().equals("") && minute.getText().toString().equals("")  && second.getText().toString().equals("") )
            return false;
        return true;
    }

    public void resetEditTexts(){

        taskDay.setText("");
        taskHour.setText("");
        taskInfo.setText("");
        taskMinute.setText("");
        taskSecond.setText("");
        taskYear.setText("");
        taskMonth.setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        taskInfo = (EditText) findViewById(R.id.TaskInfoTxt);
        taskYear = (EditText) findViewById(R.id.YearTxt);
        taskMonth = (EditText) findViewById(R.id.MonthTxt);
        taskDay = (EditText) findViewById(R.id.DayTxt);
        taskHour = (EditText) findViewById(R.id.HourTxt);
        taskMinute = (EditText) findViewById(R.id.MinuteTxt);
        taskSecond = (EditText) findViewById(R.id.SecondTxt);
        submitBtn = (Button) findViewById(R.id.SubmitBtn);
        toCalender = (Button) findViewById(R.id.goTOCalender);

/*        String M, D, H, Min, Sec;
        msg = taskInfo.getText().toString();
        Y = taskYear.getText().toString();*/

//        M = taskMonth.getText().toString();
//        D = taskDay.getText().toString();
//        H = taskHour.getText().toString();
//        Min = taskMinute.getText().toString();
//        Sec = taskSecond.getText().toString();

            submitBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent toList = new Intent(getApplicationContext(), MainActivity.class);

                    if (!(taskInfo.getText().toString().equals("") && taskYear.getText().toString().equals("")
                            && taskMonth.getText().toString().equals("") && taskDay.getText().toString().equals("")
                            && taskHour.getText().toString().equals("") && taskMinute.getText().toString().equals("") &&
                            taskSecond.getText().toString().equals(""))) {

                        if (!checkDatesEnterd(taskYear, taskMonth, taskDay, taskHour, taskMinute, taskSecond)) {

                            MainActivity.prepareData(new Task((String) taskInfo.getText().toString(), 2));

                            Toast.makeText(getApplicationContext(), "without date",
                                    Toast.LENGTH_LONG).show();

                        } else {
                            MainActivity.prepareData(new Task((String) taskInfo.getText().toString(), taskYear.getText().toString(),
                                    taskMonth.getText().toString(), taskDay.getText().toString(), taskHour.getText().toString(),
                                    taskMinute.getText().toString(), taskSecond.getText().toString(), 2));

                            Toast.makeText(getApplicationContext(), "with date",
                                    Toast.LENGTH_LONG).show();
                        }

                        startActivity(toList);

                        resetEditTexts();
                    }

                    // ****************else fill the blanks.

                }
            });

            toCalender.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent tocal = new Intent(getApplicationContext(), CalanderActivity.class);
                    startActivity(tocal);
                }
            });



    }
}
