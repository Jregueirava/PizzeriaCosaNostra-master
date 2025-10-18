package dao;

import model.LandingPageContent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LandingPageDAOImpl implements LandingPageDAO {

    private String path;

    public LandingPageDAOImpl(String path){
        this.path= path;
    }



    @Override
    public LandingPageContent getLandingPageContent(String idioma) throws IOException {

        //Objeto properties
        Properties props = new Properties();

        //Cargar el archivo

        try(FileInputStream fis = new FileInputStream(path)){
          props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Claves según el idioma

        String claveQuienesSomos = "quienes_somos." + idioma;
        String claveAmorProductos = "amor_productos." + idioma;
        String claveExperiencia = "experiencia." + idioma;

        //Obtención de valores según parámetros
        String quienesSomos = props.getProperty(claveQuienesSomos, "");
        String amorProductos = props.getProperty(claveAmorProductos, "");
        String experiencia = props.getProperty(claveExperiencia, "");

        return new LandingPageContent(quienesSomos, amorProductos, experiencia);
    }
}
