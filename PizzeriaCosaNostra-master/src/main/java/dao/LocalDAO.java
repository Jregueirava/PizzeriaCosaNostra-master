package dao;

import model.Local;

import java.io.IOException;
import java.util.List;

public interface LocalDAO {
    //Obtiene la lista completa de los locales
    List<Local> listarLocales() throws IOException;

    //Actualiza un local que ya existe o lo crea si no existe
    void actualizarLocal(Local local) throws IOException;
}
