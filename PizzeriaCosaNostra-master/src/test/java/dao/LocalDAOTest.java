package dao;

import model.Local;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LocalDAOTest {
    private final String RUTA = "src/main/resources/locales.csv";

    @Test
    void testListarLocales() throws IOException{
        LocalDAO dao = new LocalDAOImpl(RUTA);
        List<Local> locales = dao.listarLocales();

        assertNotNull(locales);
        assertFalse(locales.isEmpty());
        assertEquals("LCL001", locales.get(0).getId());
    }

    @Test
    void testActualizarLocalExistente() throws IOException{
        LocalDAO dao = new LocalDAOImpl(RUTA);
        List<Local> locales = dao.listarLocales();

        //Coge el primer local y lo modifica
        Local local = locales.get(0);
        String nombreOriginal = local.getNombre();

        //Modificar
        local.setNombre("Test - "+ nombreOriginal);
        dao.actualizarLocal(local);

        //Comprobar que se actualizó
        List<Local> localesActulizados = dao.listarLocales();

        assertEquals("Test - "+ nombreOriginal, localesActulizados.get(0).getNombre());

        //Volver al valor original
        local.setNombre(nombreOriginal);
        dao.actualizarLocal(local);
    }

    @Test
    void testActualizarLocalNuevo() throws IOException{
        LocalDAO dao = new LocalDAOImpl(RUTA);

        //Crear nuevo local
        Local nuevoLocal = new Local("LCLTEST", "Local Test", "Calle Test pizza 23", "15001", "A Coruña", "A Coruña", "981205025", 125);

        //Añadir
        dao.actualizarLocal(nuevoLocal);

        //Comprobar que se añadió
        List<Local> locales = dao.listarLocales();
        boolean encontrado = false;

        for(Local l: locales) {
            if(l.getId().equals("LCLTEST")){
                encontrado = true;
                break;
            }
        }
        assertTrue(encontrado);
    }
}
