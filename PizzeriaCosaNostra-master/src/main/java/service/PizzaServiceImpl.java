package service;

import dao.PizzaDAO;
import model.Pizza;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class PizzaServiceImpl implements PizzaService{

    private PizzaDAO dao;

    public PizzaServiceImpl(PizzaDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Pizza> listadoPizzas() throws JAXBException {
        try {
            return dao.listarPizzas();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizarPizza(Pizza p) throws JAXBException {
        try {
            dao.actualizarPizza(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
