package dao;

import model.Ingrediente;

import java.io.IOException;
import java.util.List;

public interface IngredienteDAO {

    //Obtiene la lista de los ingredientes
    List<Ingrediente> listarIngredientes() throws IOException, ClassNotFoundException;

    //Actualiza un ingrediente existente o lo crea si no existe
    void actualizarIngrediente(Ingrediente ingrediente) throws IOException, ClassNotFoundException;
}
