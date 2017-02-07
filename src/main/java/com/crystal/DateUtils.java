package com.crystal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sergey on 07.02.2017.
 */
public class DateUtils {
    public static Date parseString(String line, String pattern) throws ParseException {
        if(pattern == null) pattern = "dd.MM.yyyy HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(line);
    }
    public static Date parseString(String line) throws ParseException {
        return parseString(line, null);
    }
}
