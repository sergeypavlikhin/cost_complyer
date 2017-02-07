package com.crystal;

import org.junit.Test;

import java.text.ParseException;

/**
 * Created by Sergey on 07.02.2017.
 */
public class DateUtilsTests {

    @Test
    public void simpleTest() throws ParseException {
        DateUtils.parseString("31.01.2013 00:00:00");
        //With no exception? Good
    }

    @Test(expected = ParseException.class)
    public void simpleNegativeTest() throws ParseException {
        DateUtils.parseString("1 32.01.2013 00:00:00");
        //With no exception? Bad
    }
}
