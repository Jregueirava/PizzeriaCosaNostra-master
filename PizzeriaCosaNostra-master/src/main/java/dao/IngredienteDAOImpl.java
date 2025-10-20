package dao;

import model.Ingrediente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAOImpl implements IngredienteDAO {

    private String rutaArchivo;

    public IngredienteDAOImpl(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public List<Ingrediente> listarIngredientes() throws IOException, ClassNotFoundException {
        File archivo = new File(rutaArchivo);

        //Si no existe, la devuelve vacia

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        //Lectura lista serializada

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {

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
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))){
            oos.writeObject(ingredientes);
        }
    }
}
