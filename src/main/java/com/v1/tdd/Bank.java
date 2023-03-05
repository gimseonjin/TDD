package com.v1.tdd;

import java.util.HashMap;

public class Bank {

    private HashMap rates = new HashMap<>();

    public Money reduce(Expressions expressions, String to){
        return expressions.reduce(this, to);
    }

    public void addRate(String from, String to, Integer rate){
        rates.put(new Pair(from, to), rate);
    }

    public Integer rate(String from, String to){
        if(from.equals(to)) return 1;
        return (Integer) rates.get(new Pair(from, to));
    }
}
