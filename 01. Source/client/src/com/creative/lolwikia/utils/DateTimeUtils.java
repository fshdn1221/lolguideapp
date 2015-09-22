package com.creative.lolwikia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {

    public static Date parse(String input, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        try {
            return sdf.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String format(long milis, String outPattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(milis);
        return format(cal.getTime(), outPattern);
    }

    public static String format(Date date, String outPattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(outPattern, Locale.getDefault());
        return sdf.format(date);
    }
}
