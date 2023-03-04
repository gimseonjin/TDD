package com.v1.tdd;

public class Dollar extends Money{

    public Dollar(Integer amount, String currency) {
        super(amount, currency);
    }

    public Money times(Integer multiplier){
        return Money.dollar(this.amount * multiplier);
    }
}
