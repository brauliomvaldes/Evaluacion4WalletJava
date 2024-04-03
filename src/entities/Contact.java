package entities;

public class Contact {
	
	  int contac_id;
	  User contact_id_principal; 
	  User contact_id_referred; 
	  boolean contact_state;
	
	public Contact(int contac_id, User contact_id_principal, User contact_id_referred, boolean contact_state) {
		super();
		this.contac_id = contac_id;
		this.contact_id_principal = contact_id_principal;
		this.contact_id_referred = contact_id_referred;
		this.contact_state = contact_state;
	}

	

	public int getContac_id() {
		return contac_id;
	}



	public void setContac_id(int contac_id) {
		this.contac_id = contac_id;
	}



	public User getContact_id_principal() {
		return contact_id_principal;
	}



	public void setContact_id_principal(User contact_id_principal) {
		this.contact_id_principal = contact_id_principal;
	}



	public User getContact_id_referred() {
		return contact_id_referred;
	}



	public void setContact_id_referred(User contact_id_referred) {
		this.contact_id_referred = contact_id_referred;
	}



	public boolean isContact_state() {
		return contact_state;
	}



	public void setContact_state(boolean contact_state) {
		this.contact_state = contact_state;
	}

}
