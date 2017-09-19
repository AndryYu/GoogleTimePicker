package com.andryyu.time;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.andryyu.time.timepicker.TimePickerDialog;

import java.util.Calendar;

public class TimeActivity extends AppCompatActivity {

    private Button btnTime;
    private final Calendar mCalendar = Calendar.getInstance();
    private int hourOfDay = mCalendar.get(Calendar.HOUR_OF_DAY);
    private int minute = mCalendar.get(Calendar.MINUTE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        btnTime = (Button) findViewById(R.id.btn_time);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog(hourOfDay, minute);
            }
        });
    }


    /**
     * <p>showTimeDialog</p>
     * @param hour
     * @param minitue
     * @Description  顯示時間選擇框
     */
    public void showTimeDialog(int hour, int minitue) {
        TimePickerDialog.newInstance(new TimePickerDialog.OnTimeSetListener() {
                 @Override
                public void onTimeSet(TimePickerDialog dialog, int hourOfDay, int minute) {
                         String time = new StringBuilder().append(pad(hourOfDay)).append(":").append(pad(minute)).toString();
                         btnTime.setText(time);
                }

                @Override
                public void onTimeCleared(TimePickerDialog timePickerDialog) {

                }
                }, hour, minitue, true, true)
                .show(getFragmentManager(), "timePicker");
    }


    /**
     * <p>pad</p>
     * @param c
     * @return
     * 將int小時轉化為string
     */
    public static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
}
