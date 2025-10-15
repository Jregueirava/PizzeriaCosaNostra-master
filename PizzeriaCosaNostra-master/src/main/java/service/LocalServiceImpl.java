package service;

import dao.LocalDAO;
import model.Local;

import java.io.IOException;
import java.util.List;

public class LocalServiceImpl implements LocalService{

    private LocalDAO dao;

    public LocalServiceImpl(LocalDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Local> listadoLocales() throws IOException {
        return dao.listarLocales();
    }

    @Override
    public void actualizarLocal(Local l) throws IOException {
            dao.actualizarLocal(l);
    }
}
