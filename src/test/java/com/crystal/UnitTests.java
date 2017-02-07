package com.crystal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import com.crystal.entities.Cost;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.util.*;

/**
 * Created by Sergey on 07.02.2017.
 */
public class UnitTests {


    @Test
    public void test_main_function() throws ParseException {

        List<Cost> oldCost = Arrays.asList(
                new Cost("122856", 1, 1, DateUtils.parseString("01.01.2013 00:00:00"), DateUtils.parseString("31.01.2013 23:59:59"), 11000),
                new Cost("122856", 2, 1, DateUtils.parseString("10.01.2013 00:00:00"), DateUtils.parseString("20.01.2013 23:59:59"), 99000),
                new Cost("6654", 1, 2, DateUtils.parseString("01.01.2013 00:00:00"), DateUtils.parseString("31.01.2013 00:00:00"), 5000));

        List<Cost> newCost = Arrays.asList(
                new Cost("122856", 1, 1, DateUtils.parseString("20.01.2013 00:00:00"), DateUtils.parseString("20.02.2013 23:59:59"), 11000),
                new Cost("122856", 2, 1, DateUtils.parseString("15.01.2013 00:00:00"), DateUtils.parseString("25.01.2013 23:59:59"), 92000),
                new Cost("6654", 1, 2, DateUtils.parseString("12.01.2013 00:00:00"), DateUtils.parseString("13.01.2013 00:00:00"), 4000));

        List<Cost> expected = Arrays.asList(
                new Cost("122856", 1, 1, DateUtils.parseString("20.01.2013 00:00:00"), DateUtils.parseString("20.02.2013 23:59:59"), 11000),
                new Cost("122856", 2, 1, DateUtils.parseString("15.01.2013 00:00:00"), DateUtils.parseString("25.01.2013 23:59:59"), 92000),
                new Cost("6654", 1, 2, DateUtils.parseString("12.01.2013 00:00:00"), DateUtils.parseString("13.01.2013 00:00:00"), 4000));

        List<Cost> actual =  CostComplyer.comply(null, null);
    }

    /**
     * Like
     * ///////////////////////
     * |||||||||||||||||||||||||||||
     *
     */
    @Test
    public void test_merge_functions_by_date_1() throws ParseException {
        Date beginDate = DateUtils.parseString("01.01.2013 00:00:00");
        Date endDate_1 = DateUtils.parseString("31.01.2013 23:59:59");
        Date endDate_2 = DateUtils.parseString("13.02.2013 23:59:59");

        Cost cost_1 = new Cost("1A", 1, 1, beginDate, endDate_1, 11000);
        Cost cost_2 = new Cost("1A", 1, 1, beginDate, endDate_2, 11000);

        List<Cost> actual = CostMergeUtils.mergeCosts(cost_1, cost_2);

        List<Cost> expected = Arrays.asList(cost_2);

        assertThat(actual, is(expected));
     }


    /**
     * Like
     * ///////////////////////
     * /////|||||||///////////
     *
     */
    @Test
    public void test_merge_functions_by_values_1() throws ParseException {

        Cost cost_1 = new Cost("1A", 1, 1, DateUtils.parseString("01.01.2013 00:00:00"), DateUtils.parseString("31.01.2013 23:59:59"), 11000);
        Cost cost_2 = new Cost("1A", 1, 1, DateUtils.parseString("10.01.2013 00:00:00"), DateUtils.parseString("17.01.2013 23:59:59"), 7000);

        List<Cost> actual = CostMergeUtils.mergeCosts(cost_1, cost_2);

        List<Cost> expected = Arrays.asList(
                new Cost("1A", 1, 1, DateUtils.parseString("01.01.2013 00:00:00"), DateUtils.parseString("10.01.2013 23:59:59"), 11000),
                new Cost("1A", 1, 1, DateUtils.parseString("10.01.2013 00:00:00"), DateUtils.parseString("17.01.2013 23:59:59"), 7000),
                new Cost("1A", 1, 1, DateUtils.parseString("17.01.2013 00:00:00"), DateUtils.parseString("31.01.2013 23:59:59"), 11000));

        assertThat(actual, is(expected));
    }
}
