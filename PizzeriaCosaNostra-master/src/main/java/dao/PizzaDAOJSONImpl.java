package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Pizza;

import javax.xml.bind.JAXBException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;


//Exportar pizzas a JSON con Gson
public class PizzaDAOJSONImpl  implements PizzaDAO{


    private String path;
    private Gson gson;

    public PizzaDAOJSONImpl(String path, Gson gson) {
        this.path = path;
        //Config Gson con el formato legible
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public List<Pizza> listarPizzas() throws JAXBException, IOException {
        //No se usa para la implementación del JSON
        throw new UnsupportedOperationException("Usa PizzaDAOXMLImpl para listar pizzas");
    }

    @Override
    public void actualizarPizza(Pizza pizza) throws JAXBException, IOException {
        //No se usa al implementar JSON
        throw new UnsupportedOperationException("Usa PizzaDAOXMLImpl para actualizar pizzas");
    }

    @Override
    public void exportarPizzasJSON(List<Pizza> pizzas) throws IOException {
        Writer writer = new FileWriter(path);
        //Conversion de la lista de pizzas a JSON y las escribe
        gson.toJson(pizzas,writer);
        writer.close();
    }
}
