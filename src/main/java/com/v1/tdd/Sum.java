package com.v1.tdd;

public class Sum implements Expressions {
    Expressions augend;
    Expressions added;

    public Sum(Expressions augend, Expressions added) {
        this.augend = augend;
        this.added = added;
    }

    public Money reduce(Bank bank, String to){
        return new Money(augend.reduce(bank,to).amount + added.reduce(bank,to).amount, to);
    }

    @Override
    public Expressions plus(Expressions added) {
        return new Sum(this, added);
    }

    public Expressions times(Integer multiplier) {
        return new Sum(augend.times(multiplier), added.times(multiplier));
    }
}
