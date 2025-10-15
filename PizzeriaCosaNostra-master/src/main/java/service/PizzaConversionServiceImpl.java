package service;

import dao.PizzaDAO;
import model.Pizza;

import java.util.List;

public class PizzaConversionServiceImpl implements PizzaConversionService{

    private PizzaDAO daoXML;
    private PizzaDAO daoJSON;

    public PizzaConversionServiceImpl(PizzaDAO daoXML, PizzaDAO daoJSON) {
        this.daoXML = daoXML;
        this.daoJSON = daoJSON;
    }

    @Override
    public boolean generarFicheroPizzas() {
        try{
            //Leer pizzas XML
            List<Pizza> pizzas = daoXML.listarPizzas();
            //Exportar pizzas a JSON
            daoJSON.exportarPizzasJSON(pizzas);

            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
