package com.example.e.Calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e.R;

import java.util.HashMap;

public class Calendar extends AppCompatActivity {
    private ZWCalendarView calendarView;
    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendarView = (ZWCalendarView) findViewById(R.id.calendarView);
        show = (TextView) findViewById(R.id.tv_calendar_show);

        calendarView.setSelectListener(new ZWCalendarView.SelectListener() {
            @Override
            public void change(int year, int month) {
                show.setText(String.format("%s 年 %s 月", year, month));
            }

            @Override
            public void select(int year, int month, int day, int week) {
                Toast.makeText(getApplicationContext(),
                        String.format("%s 年 %s 月 %s日，周%s", year, month, day, week),
                        Toast.LENGTH_SHORT).show();
            }
        });

        //代码选中一个日期
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.selectDate(2017, 9, 3);
            }
        });

        //前一月
        findViewById(R.id.calendar_previous).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.showPreviousMonth();
            }
        });

        //后一月
        findViewById(R.id.calendar_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.showNextMonth();
            }
        });

        //返回今天
        findViewById(R.id.tv_calendar_today).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.backToday();
            }
        });

        HashMap<String, Boolean> sign = new HashMap<>();
        sign.put("2019-07-24",false);
        sign.put(calendarView.getYestoday(),true);
        calendarView.setSignRecords(sign);

    }
}
