package dao;

import model.Ingrediente;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class IngredienteDAOTest {

    private final String RUTA = "src/main/resources/ingredientes.dat";

    @Test
    void testListarIngredientes() throws IOException, ClassNotFoundException{
            IngredienteDAO dao = new IngredienteDAOImpl(RUTA);

            List<Ingrediente> ingredientes = dao.listarIngredientes();

            assertNotNull(ingredientes);
            assertFalse(ingredientes.isEmpty());
            assertEquals("ING001", ingredientes.get(0).getId());

    }

    @Test
    void testActualizarIngredienteExistente() throws IOException, ClassNotFoundException{
        IngredienteDAO dao = new IngredienteDAOImpl(RUTA);
        List<Ingrediente> ingredientes = dao.listarIngredientes();

        //Modificar el primer ingrediente
        Ingrediente ingrediente = ingredientes.get(0);
        String nombreOriginal = ingrediente.getNombre();

        //Modificar
        ingrediente.setNombre("TEST");
        dao.actualizarIngrediente(ingrediente);

        //Comprobar que se añadio
        List<Ingrediente> ingredientesActualizados = dao.listarIngredientes();

        assertEquals("TEST", ingredientesActualizados.get(0).getNombre());

        //Volver a los ingredientes de antes
        ingrediente.setNombre(nombreOriginal);
        dao.actualizarIngrediente(ingrediente);
    }

    @Test
    void testActualizarIngredienteNuevo() throws IOException, ClassNotFoundException{
        IngredienteDAO dao = new IngredienteDAOImpl(RUTA);

        //Crear nuevo ingrediente

        //Ingrediente nuevoIngrediente = new Ingrediente("INGTEST", "Ingrediente Test", Arrays.asList( new Alergeno("Gluten"), new Alergeno("Lactosa")));


        //Añadir
        //dao.actualizarIngrediente(nuevoIngrediente);
        //Comprobar
        List<Ingrediente> ingredientes = dao.listarIngredientes();

        boolean encontrado = true;
        for(Ingrediente i: ingredientes){
            if(i.getId().equals("INGTEST")){
                encontrado= true;
                break;
            }
        }
        assertTrue(encontrado);
    }

}
