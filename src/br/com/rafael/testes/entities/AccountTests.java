package br.com.rafael.testes.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.rafael.entites.Account;
import br.com.rafael.testes.entities.factory.AccountyFactory;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.0;
		double expectedValue = 196.0;
		Account ac = AccountyFactory.createEmptyAccount();
		ac.deposit(amount);
		
		Assertions.assertEquals(expectedValue, ac.getBalance());
		
	}
	
	@Test
	public void depositShouldDoNothingNegativeAmount() {
		double expectedValue= 100.0;
		Account ac = AccountyFactory.createAccount(expectedValue);
		double amount = -200.0;
		
		ac.deposit(amount);
		Assertions.assertEquals(expectedValue, ac.getBalance());
		
	}
	
	@Test
	public void fullWithDrawShouldClearBalance() {
		
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account ac = AccountyFactory.createAccount(800.0);
		
		
		 double result = ac.fullWithDraw();
		 System.out.println(result);
		 Assertions.assertTrue(expectedValue ==  ac.getBalance());
		 Assertions.assertTrue(result == expectedValue);
		
	}
	
	@Test
	public void withdrawmShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account ac = AccountyFactory.createAccount(800.0);
		ac.withDraw(500.0);
		
		Assertions.assertEquals(300.00, ac.getBalance());
	}
	
	@Test
	public void withdrawnShouldThrowExceptionWhenInsufficientBalance() {
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Account ac = AccountyFactory.createAccount(800.0);
			ac.withDraw(900.0);
		});
	}

}
