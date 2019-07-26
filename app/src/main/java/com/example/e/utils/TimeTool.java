package com.example.e.utils;

import java.util.Calendar;

public class TimeTool {
    //早中晚的调节亮度值
    private static final int morning = 100;
    private static final int afternoon = 150;
    private static final int night = 80;

    public static int getAutoAlapha(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if(hour>7&&hour<12)
            return morning;
        else if(hour>12&&hour<19)
            return afternoon;
        else
            return night;

    }


}
