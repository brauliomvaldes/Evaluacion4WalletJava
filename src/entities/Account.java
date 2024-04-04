package entities;

import java.util.Currency;
import java.util.Date;

// Clase que representa una cuenta en el sistema
public class Account {
    
    // Campos de la cuenta
    private int account_id; // Identificador único de la cuenta
    private User account_user; // Usuario asociado a la cuenta
    private String account_number; // Número único de la cuenta
    private float account_balance; // Saldo actual de la cuenta
    private Currency account_currency_id; // Moneda de la cuenta
    private Date account_created_at; // Fecha de creación de la cuenta
    private TypeOfAccount account_type_id; // Tipo de cuenta (por ejemplo, corriente, ahorro, etc.)
    private Bank account_bank_id; // Banco al que pertenece la cuenta
    private boolean account_state; // Estado de la cuenta (activo/inactivo)

    // Constructor predeterminado
    public Account() {}

    // Constructor con parámetros
    // Corrección: Se ha corregido el nombre del parámetro de la clase Currency
    public Account(int account_id, User account_user, String account_number, float account_balance,
            Currency account_currency_id, Date account_created_at, TypeOfAccount account_type_id, Bank account_bank_id,
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

    // Getters y setters para cada campo

    // Corrección: Cambiar el nombre del getter para cumplir con la convención de JavaBeans
    public int getAccount_id() {
        return account_id;
    }

    // Corrección: Cambiar el nombre del setter para cumplir con la convención de JavaBeans
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

    public Currency getAccount_currency_id() {
        return account_currency_id;
    }

    public void setAccount_currency_id(Currencyy moneda) {
        this.account_currency_id = moneda;
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
