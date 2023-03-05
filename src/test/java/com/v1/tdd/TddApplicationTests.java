package com.v1.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MoneyTest{
	@Test
	public void testMultiplication(){
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}

	@Test
	public void testEquality(){
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}

	@Test
	public void testCurrency(){
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}

	@Test
	public  void testSimpleAddition() {
		Expressions sum = Money.dollar(5).plus(Money.dollar(7));
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(12), reduced);
	}

	@Test
	public  void testPlusReturnSum() {
		Money five = Money.dollar(5);
		Expressions result = five.plus(five);
		Sum sum = (Sum) result;
		assertEquals(Money.dollar(5), sum.augend);
		assertEquals(Money.dollar(5), sum.added);
	}

	@Test
	public  void testReduceMoney() {
		Bank bank = new Bank();
		Money reduced = bank.reduce(Money.dollar(5), "USD");
		assertEquals(Money.dollar(5), reduced);
	}

	@Test
	public void testReduceMoneyDifferentCurrency(){
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(Money.franc(2), "USD");
		assertEquals(Money.dollar(1), result);
	}

	@Test
	public void testMixedAddition(){
		Expressions fiveBucks = Money.dollar(5);
		Expressions tenFrancs = Money.franc(10);

		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
		assertEquals(Money.dollar(10), result);
	}

	@Test
	public void testSumTimes(){
		Expressions fiveBucks = Money.dollar(5);
		Expressions tenFrancs = Money.franc(10);

		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);

		Expressions sum = new Sum(fiveBucks, tenFrancs).times(2);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(20), result);
	}
}

