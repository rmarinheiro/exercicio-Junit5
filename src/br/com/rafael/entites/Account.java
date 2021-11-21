package br.com.rafael.entites;

public class Account {

	
	public static double DOUBLE_FEE_PERCENTAGE = 0.02;
	private Long id;
	private Double balance;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(Long id, Double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		if(amount > 0) {
			amount = amount - amount * DOUBLE_FEE_PERCENTAGE;
			balance = balance + amount;
		}
		
	}
	
	public void withDraw(double amount) {
		if(amount > balance) {
			throw new IllegalArgumentException("Saldo Insuficiente");
		}
		balance = balance - amount;
	}
	
	public double fullWithDraw() {
		double aux = balance;
		balance = 0.0;
		return balance;
	}

}
