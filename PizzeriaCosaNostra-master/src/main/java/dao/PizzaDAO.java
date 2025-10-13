package dao;

import model.Pizza;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface PizzaDAO {
    //Obtiene la lista de las pizzas
    List<Pizza> listarPizzas() throws JAXBException, IOException;

    //Actualiza la pizza qu ya existe o la crea
    void actualizarPizza(Pizza pizza) throws JAXBException, IOException;

    //Exporta la lista de pizzas en JSON
    void exportarPizzasJSON(List<Pizza> pizzas) throws IOException;
}
