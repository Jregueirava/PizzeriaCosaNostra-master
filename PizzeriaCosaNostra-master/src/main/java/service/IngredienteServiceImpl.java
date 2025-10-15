package service;

import dao.IngredienteDAO;
import model.Ingrediente;

import java.io.IOException;
import java.util.List;

public class IngredienteServiceImpl implements IngredienteService{

    private IngredienteDAO dao;

    public IngredienteServiceImpl(IngredienteDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Ingrediente> listadoIngredientes() throws IOException, ClassNotFoundException {
        return dao.listarIngredientes();
    }

    @Override
    public void actualizarIngrediente(Ingrediente ing) throws IOException, ClassNotFoundException {
        dao.actualizarIngrediente(ing);
    }
}
