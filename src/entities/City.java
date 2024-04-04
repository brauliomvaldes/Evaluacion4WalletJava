package entities;

// Clase que representa una ciudad
public class City {
	
    // Campos de la ciudad
    private int city_id; // Identificador único de la ciudad
    private String city_name; // Nombre de la ciudad

    // Constructor con parámetros
    // Mejora: Un constructor con parámetros puede ser útil para inicializar todos los campos de la ciudad
    public City(int city_id, String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }

    // Getters y setters para cada campo

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

}
