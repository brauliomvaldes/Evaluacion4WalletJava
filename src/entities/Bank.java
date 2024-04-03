package entities;

public class Bank  {

	int bank_id;
	String bank_nombre;
	boolean bank_state;

	public Bank() {};
	
	public Bank(int bank_id, String bank_nombre, boolean bank_state) {
		super();
		this.bank_id = bank_id;
		this.bank_nombre = bank_nombre;
		this.bank_state = bank_state;
	}

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_nombre() {
		return bank_nombre;
	}

	public void setBank_nombre(String bank_nombre) {
		this.bank_nombre = bank_nombre;
	}

	public boolean isBank_state() {
		return bank_state;
	}

	public void setBank_state(boolean bank_state) {
		this.bank_state = bank_state;
	}

}