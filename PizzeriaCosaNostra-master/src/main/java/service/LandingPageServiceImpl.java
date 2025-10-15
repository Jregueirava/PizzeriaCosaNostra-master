package service;

import dao.LandingPageDAO;
import model.LandingPageContent;

public class LandingPageServiceImpl implements LandingPageService{

    private LandingPageDAO dao;

    public LandingPageServiceImpl(LandingPageDAO dao) {
        this.dao = dao;
    }

    @Override
    public LandingPageContent getLandingPageContent(String idioma) {
        try{
            return dao.getLandingPageContent(idioma);
        } catch(Exception e){
            e.printStackTrace();
            //En caso de error lo devuelve vacio de contenido
            return new LandingPageContent("", "", "");
        }
    }
}
