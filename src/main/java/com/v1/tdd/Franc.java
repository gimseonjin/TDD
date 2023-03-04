package com.v1.tdd;

public class Franc extends Money{


    public Franc(Integer amount, String currency) {
        super(amount, currency);
    }

    public Money times(Integer multiplier){
        return Money.franc(this.amount * multiplier);
    }

}
