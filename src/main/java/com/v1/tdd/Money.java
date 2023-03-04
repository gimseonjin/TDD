package com.v1.tdd;

import java.util.Objects;

public abstract class Money {
    protected Integer amount;
    protected String currency;

    public Money(Integer amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    public static Money dollar(Integer amount){
        return new Dollar(amount, "USD");
    }

    public static Money franc(Integer amount){
        return new Franc(amount, "CHF");
    }

    abstract Money times(Integer multiplier);

    public String currency(){
        return currency;
    }
}
