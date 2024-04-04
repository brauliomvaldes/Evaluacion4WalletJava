package persistence;

import java.util.ArrayList;

// Interfaz para definir operaciones básicas de persistencia para entidades
public interface IUseEntities<T>{

    // Método para encontrar todos los elementos de la colección
    void findAll(ArrayList<T> t);
    
    // Método para encontrar un elemento por su ID
    void findById(int id, ArrayList<T> t);
    
    // Método para guardar un nuevo elemento
    ArrayList<T> save(T trf, ArrayList<T> t);
    
    // Método para eliminar un elemento por su ID
    ArrayList<T> delete(int id, ArrayList<T> t);

    // Mejora: Método para actualizar un elemento existente en la colección
    void update(T trf, ArrayList<T> t);
}
