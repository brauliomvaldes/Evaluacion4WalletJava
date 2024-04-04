package entities;

// Clase que representa un banco
public class Bank {
	
    // Campos del banco
    private int bank_id; // Identificador único del banco
    private String bank_nombre; // Nombre del banco
    private boolean bank_state; // Estado del banco (activo/inactivo)

    // Constructor predeterminado
    public Bank() {}

    // Constructor con parámetros
    // Mejora: Un constructor con parámetros puede ser útil para inicializar todos los campos del banco
    public Bank(int bank_id, String bank_nombre, boolean bank_state) {
        this.bank_id = bank_id;
        this.bank_nombre = bank_nombre;
        this.bank_state = bank_state;
    }

    // Getters y setters para cada campo

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
