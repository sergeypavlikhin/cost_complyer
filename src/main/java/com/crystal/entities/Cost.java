package com.crystal.entities;

import java.util.Date;

/**
 * Created by Sergey on 07.02.2017.
 */
public class Cost implements Cloneable, Comparable<Cost> {

    private long id; // идентификатор в БД
    private String product_code; // код товара
    private int number; // номер цены
    private int depart; // номер отдела
    private Date begin; // начало действия
    private Date end; // конец действия
    private long value; // значение цены в копейках

    public Cost(long id, String product_code, int number, int depart, Date begin, Date end, long value) {
        this.id = id;
        this.product_code = product_code;
        this.number = number;
        this.depart = depart;
        this.begin = begin;
        this.end = end;
        this.value = value;
    }

    public Cost(String product_code, int number, int depart, Date begin, Date end, long value) {
        this(0, product_code, number, depart, begin, end, value);
    }

    public boolean overlapDates(Cost cost){
        if (begin.before(cost.begin)) return end.after(cost.begin);
        else if (begin.before(cost.end)) return true;
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cost cost = (Cost) o;

        return id == cost.id;
    }

    @Override
    public Cost clone() {
        return new Cost(id, product_code, number, depart, begin, end, value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Long.hashCode(id);
        result = prime * result + (product_code != null ? product_code.hashCode() : 1);
        result = prime * result + (begin != null ? begin.hashCode() : 1);
        result = prime * result + (end != null ? end.hashCode() : 1);
        result = prime * result + number;
        result = prime * result + depart;
        result = prime * result + Long.hashCode(value);
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDepart() {
        return depart;
    }

    public void setDepart(int depart) {
        this.depart = depart;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public int compareTo(Cost o) {
       if(end.after(o.end)) return 1;
       else if (end.before(o.end))return -1;
       else return 0;
    }
}
