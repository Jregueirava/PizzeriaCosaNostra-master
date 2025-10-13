package dao;

import model.LandingPageContent;

import java.io.IOException;

public interface LandingPageDAO {
    //Obtiene el contenido de la landing page segun el idioma
    LandingPageContent getLandingPageContent(String idioma) throws IOException;
}
