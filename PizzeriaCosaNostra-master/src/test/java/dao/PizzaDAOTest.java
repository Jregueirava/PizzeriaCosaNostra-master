package dao;

import model.Pizza;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaDAOTest {
    private final String RUTA_XML = "src/main/resources/Carta.xml";
    private final String RUTA_JSON = "src/main/resources/Pizzas.json";

    @Test
    void testListarPizzasXML() throws JAXBException, IOException {
        PizzaDAO dao = new PizzaDAOXMLImpl(RUTA_XML);
        List<Pizza> pizzas = dao.listarPizzas();

        assertNotNull(pizzas);
        assertFalse(pizzas.isEmpty());
        assertEquals("PZZ001", pizzas.get(0).getId());
    }

    @Test
    void testActualizarPizzaXML() throws JAXBException, IOException {
        PizzaDAO dao = new PizzaDAOXMLImpl(RUTA_XML);
        List<Pizza> pizzas = dao.listarPizzas();

        //Modificar la primera pizza
        Pizza pizza = pizzas.get(0);
        String nombreOriginal = pizza.getNombre();

        //Modificar
        pizza.setNombre("TEST");
        dao.actualizarPizza(pizza);

        //Comprobar
        List<Pizza> pizzasActualizadas = dao.listarPizzas();
        assertEquals("TEST", pizzasActualizadas.get(0).getNombre());

        //Volver al original
        pizza.setNombre(nombreOriginal);
        dao.actualizarPizza(pizza);
    }

    @Test
    void testActualizarPizzaNuevaXML() throws JAXBException, IOException {
        PizzaDAO dao = new PizzaDAOXMLImpl(RUTA_XML);

        //Crear nueva pizza
        Pizza nuevaPizza = new Pizza(
                "PZZTEST",
                "Pizza Test",
                "Pizza de prueba",
                800,
                9.99,
                15,
                Arrays.asList("ING001", "ING002")
        );

        //Añadir
        dao.actualizarPizza(nuevaPizza);

        //Comprobar
        List<Pizza> pizzas = dao.listarPizzas();
        boolean encontrado = false;
        for (Pizza p : pizzas) {
            if (p.getId().equals("PZZTEST")) {
                encontrado = true;
                break;
            }
        }
        assertTrue(encontrado);
    }

    @Test
    void testExportarJSON() throws JAXBException, IOException {
        PizzaDAO daoXML = new PizzaDAOXMLImpl(RUTA_XML);
        PizzaDAO daoJSON = new PizzaDAOJSONImpl(RUTA_JSON);

        //Leer pizzas del XML
        List<Pizza> pizzas = daoXML.listarPizzas();

        //Exportar a JSON
        daoJSON.exportarPizzasJSON(pizzas);

        //Comprobar que el archivo JSON se creo
        File archivoJSON = new File(RUTA_JSON);
        assertTrue(archivoJSON.exists());
        assertTrue(archivoJSON.length() > 0);
    }
}

