package entities;

import java.util.Date;


public class Account{
	
	  int account_id;  
	  User account_user; 
	  String account_number;  
	  float account_balance;
	  Currencyy account_currency_id; 
	  Date account_created_at; 
	  TypeOfAccount account_type_id; 
	  Bank account_bank_id; 
	  boolean account_state; 
	
	public Account() {};
	  
	public Account(int account_id, User account_user, String account_number, float account_balance,
			Currencyy account_currency_id, Date account_created_at, TypeOfAccount account_type_id, Bank account_bank_id,
			boolean account_state) {
		this.account_id = account_id;
		this.account_user = account_user;
		this.account_number = account_number;
		this.account_balance = account_balance;
		this.account_currency_id = account_currency_id;
		this.account_created_at = account_created_at;
		this.account_type_id = account_type_id;
		this.account_bank_id = account_bank_id;
		this.account_state = account_state;
	}


	public int getAccount_id() {
		return account_id;
	}


	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}


	public User getAccount_user() {
		return account_user;
	}


	public void setAccount_user(User account_user) {
		this.account_user = account_user;
	}


	public String getAccount_number() {
		return account_number;
	}


	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}


	public float getAccount_balance() {
		return account_balance;
	}


	public void setAccount_balance(float account_balance) {
		this.account_balance = account_balance;
	}


	public Currencyy getAccount_currency_id() {
		return account_currency_id;
	}


	public void setAccount_currency_id(Currencyy account_currency_id) {
		this.account_currency_id = account_currency_id;
	}


	public Date getAccount_created_at() {
		return account_created_at;
	}


	public void setAccount_created_at(Date account_created_at) {
		this.account_created_at = account_created_at;
	}


	public TypeOfAccount getAccount_type_id() {
		return account_type_id;
	}


	public void setAccount_type_id(TypeOfAccount account_type_id) {
		this.account_type_id = account_type_id;
	}


	public Bank getAccount_bank_id() {
		return account_bank_id;
	}


	public void setAccount_bank_id(Bank account_bank_id) {
		this.account_bank_id = account_bank_id;
	}


	public boolean isAccount_state() {
		return account_state;
	}


	public void setAccount_state(boolean account_state) {
		this.account_state = account_state;
	}



}
