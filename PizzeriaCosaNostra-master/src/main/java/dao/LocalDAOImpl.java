package dao;

import model.Local;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocalDAOImpl implements LocalDAO{

     private String path;

    public LocalDAOImpl(String path) {
        this.path = path;
    }

    @Override
    public List<Local> listarLocales() throws IOException {
        List<Local> locales = new ArrayList<>();

        //Leer el csv con BufferedReader

        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            //Leer la cabecera
            String linea = reader.readLine();
            //Leer el resto
            while((linea = reader.readLine()) !=null){
                String[] campos = linea.split(",");

                //Verificacion de los campos
                if(campos.length == 8){
                    Local local = new Local(
                         /*id*/   campos[0].trim(),
                            /*Nombre*/    campos[1].trim(),
                            /*Dirección*/    campos[2].trim(),
                            /*CP*/   campos[3].trim(),
                            /*Población*/  campos[4].trim(),
                            /*Provincia*/  campos[5].trim(),
                            /*Tlf*/  campos[6].trim(),
                            /*m2*/  Integer.parseInt(campos[7]. trim())

                    );
                    locales.add(local);
                }
            }

        }
        return locales;
    }

    @Override
    public void actualizarLocal(Local local) throws IOException {

        //Leer los locales que existen actualmente
        List<Local> locales = listarLocales();

        //Búsqueda del local por id y si existe/no existe actulizar/crear
        boolean encontrado = false;

        /*TODO*/
        for(int i = 0; i < locales.size(); i++){

        }


    }
}
