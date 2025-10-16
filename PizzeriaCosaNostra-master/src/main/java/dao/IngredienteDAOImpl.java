package dao;

import model.Ingrediente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAOImpl implements IngredienteDAO {

    private String pathIngredientes;

    public IngredienteDAOImpl(String path) {
        this.pathIngredientes = pathIngredientes;
    }

    @Override
    public List<Ingrediente> listarIngredientes() throws IOException, ClassNotFoundException {
        File archivo = new File(pathIngredientes);

        //Si no existe, la devuelve vacia

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        //Lectura lista serializada

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathIngredientes))) {
            @SuppressWarnings("unchecked")
            List<Ingrediente> ingredientes = (List<Ingrediente>)
                    ois.readObject();
            return ingredientes;
        }

    }


    @Override
    public void actualizarIngrediente(Ingrediente ingrediente) throws IOException, ClassNotFoundException {
        //Leer lista de ingredientes
        List<Ingrediente> ingredientes = listarIngredientes();

        //Buscar actualizar y añadir
        boolean encontrado = false;
        for(int i = 0; i< ingredientes.size(); i++){
            if(ingredientes.get(i).getId().equals(ingrediente.getId())){
                encontrado = true;
                break;
            }
        }
        //Si no se encuentra lo actualiza
        if(!encontrado){
            ingredientes.add(ingrediente);
        }

        //Lista Guardada
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathIngredientes))){
            oos.writeObject(ingredientes);
        }
    }
}
