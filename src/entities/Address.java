package entities;

// Clase que representa una dirección postal
public class Address {
	
    // Campos de la dirección
    private int address_id; // Identificador único de la dirección
    private String address_street; // Nombre de la calle
    private City address_city; // Ciudad de la dirección
    private Country address_country; // País de la dirección
    private String address_phone_number; // Número de teléfono asociado a la dirección

    // Constructor predeterminado
    public Address() {}

    // Constructor con parámetros
    // Mejora: Un constructor con parámetros puede ser útil para inicializar todos los campos de la dirección
    public Address(int address_id, String address_street, City address_city, Country address_country, String address_phone_number) {
        this.address_id = address_id;
        this.address_street = address_street;
        this.address_city = address_city;
        this.address_country = address_country;
        this.address_phone_number = address_phone_number;
    }

    // Getters y setters para cada campo

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress_street() {
        return address_street;
    }

    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }

    public City getAddress_city() {
        return address_city;
    }

    public void setAddress_city(City address_city) {
        this.address_city = address_city;
    }

    public Country getAddress_country() {
        return address_country;
    }

    public void setAddress_country(Country address_country) {
        this.address_country = address_country;
    }

    public String getAddress_phone_number() {
        return address_phone_number;
    }

    public void setAddress_phone_number(String address_phone_number) {
        this.address_phone_number = address_phone_number;
    }

}
