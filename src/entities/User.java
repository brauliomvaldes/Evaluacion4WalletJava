package entities;
import java.util.ArrayList;
import java.util.Date;

public class User{
	
	  int user_id;  
	  String user_name; 
	  String user_lastname; 
	  String user_identity_number;  
	  String user_email;
	  String user_username; 
	  String user_password_hash; 
	  Date user_created_at; 
	  short user_age; 
	  boolean user_sex; 
	  boolean user_married;
	  boolean user_has_contact;
	  boolean user_state; 
	  ArrayList<Address> address;
	
	  
	public User() {};
	
	public User(int user_id, String user_name, String user_lastname, String user_identity_number, String user_email,
			String user_username, String user_password_hash, Date user_created_at, short user_age, boolean user_sex,
			boolean user_married, boolean user_has_contact, boolean user_state, ArrayList<Address> address) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_lastname = user_lastname;
		this.user_identity_number = user_identity_number;
		this.user_email = user_email;
		this.user_username = user_username;
		this.user_password_hash = user_password_hash;
		this.user_created_at = user_created_at;
		this.user_age = user_age;
		this.user_sex = user_sex;
		this.user_married = user_married;
		this.user_has_contact = user_has_contact;
		this.user_state = user_state;
		this.address = address;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_lastname() {
		return user_lastname;
	}


	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}


	public String getUser_identity_number() {
		return user_identity_number;
	}


	public void setUser_identity_number(String user_identity_number) {
		this.user_identity_number = user_identity_number;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_username() {
		return user_username;
	}


	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}


	public String getUser_password_hash() {
		return user_password_hash;
	}


	public void setUser_password_hash(String user_password_hash) {
		this.user_password_hash = user_password_hash;
	}


	public Date getUser_created_at() {
		return user_created_at;
	}


	public void setUser_created_at(Date user_created_at) {
		this.user_created_at = user_created_at;
	}


	public short isUser_age() {
		return user_age;
	}


	public void setUser_age(short user_age) {
		this.user_age = user_age;
	}


	public boolean isUser_sex() {
		return user_sex;
	}


	public void setUser_sex(boolean user_sex) {
		this.user_sex = user_sex;
	}


	public boolean isUser_married() {
		return user_married;
	}


	public void setUser_married(boolean user_married) {
		this.user_married = user_married;
	}


	public boolean isUser_has_contact() {
		return user_has_contact;
	}


	public void setUser_has_contact(boolean user_has_contact) {
		this.user_has_contact = user_has_contact;
	}


	public boolean isUser_state() {
		return user_state;
	}


	public void setUser_state(boolean user_state) {
		this.user_state = user_state;
	}


	public ArrayList<Address> getAddress() {
		return address;
	}


	public void setAddress(ArrayList<Address> address) {
		this.address = address;
	}

}
