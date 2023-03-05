package com.v1.tdd;

public interface Expressions {
    Money reduce(Bank bank, String to);
    Expressions plus(Expressions added);
    Expressions times(Integer multiplier);
}
