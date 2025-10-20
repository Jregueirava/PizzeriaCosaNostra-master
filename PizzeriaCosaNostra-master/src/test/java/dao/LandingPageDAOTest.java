package dao;

import model.LandingPageContent;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LandingPageDAOTest {

    private final String RUTA = "src/main/resources/config.properties";

    @Test
    void testGetLandingPageContentES() throws IOException{
        LandingPageDAO dao  = new LandingPageDAOImpl(RUTA);
        LandingPageContent content = dao.getLandingPageContent("ES");

        assertNotNull(content);
        assertFalse(content.getQuienesSomos().contains("pizzería"));
    }

    @Test
    void testGetLandingPageContentEN() throws IOException{
        LandingPageDAO dao = new LandingPageDAOImpl(RUTA);
        LandingPageContent content = dao.getLandingPageContent("EN");

        assertNotNull(content);
        assertFalse(content.getQuienesSomos().isEmpty());
    }

    @Test
    void testGetLandingPageContentGL() throws  IOException{
        LandingPageDAO dao = new LandingPageDAOImpl(RUTA);
        LandingPageContent content = dao.getLandingPageContent("GL");

        assertNotNull(content);
        assertFalse(content.getQuienesSomos().isEmpty());
    }
}
