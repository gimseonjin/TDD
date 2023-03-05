package com.v1.tdd;

import java.util.Objects;

public class Money implements Expressions {
    protected Integer amount;
    protected String currency;

    public Money(Integer amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount) && this.currency.equals(((Money) o).currency);
    }

    public static Money dollar(Integer amount){
        return new Money(amount, "USD");
    }

    public static Money franc(Integer amount){
        return new Money(amount, "CHF");
    }

    public Expressions times(Integer multiplier) {
        return new Money(this.amount * multiplier, currency);
    }

    public String currency(){
        return currency;
    }

    public Expressions plus(Expressions addend) {
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to){
        Integer rate = bank.rate(this.currency, to);
        return new Money(amount / rate, to);
    }
}
