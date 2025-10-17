package dao;

import model.Carta;
import model.Pizza;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PizzaDAOXMLImpl implements PizzaDAO {

    private String pathPizza = "src/main/resources/Carta.xml";

    public PizzaDAOXMLImpl(String path) {
        this.pathPizza = pathPizza;
    }

    //Leer  carta Xml
    private Carta leerXML() throws JAXBException{
        File archivo = new File(pathPizza);

        //No existe, carta vacia
        if(!archivo.exists()){
            return new Carta();
        }

        //JAXB contexto y unmarshaller
        JAXBContext context = JAXBContext.newInstance(Carta.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        //Leer el xml y convertir la carta a objeto
        Carta carta = (Carta) unmarshaller.unmarshal(archivo);

        //Si carta es null

        if(carta == null){
            carta = new Carta();
        }
        return carta;
    }

    //Guardar el XML
    private void guardarXML(Carta carta) throws JAXBException{
        //Contexto del JAXB y marshaller
        JAXBContext  context = JAXBContext.newInstance(Carta.class);
        Marshaller marshaller = context.createMarshaller();

        //Conf formato salida
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        //Escribe la carta en objeto en el XML
        marshaller.marshal(carta, new File(pathPizza));
    }


    @Override
    public List<Pizza> listarPizzas() throws JAXBException, IOException {
        Carta carta = leerXML();
        return carta.getPizzas();
    }

    @Override
    public void actualizarPizza(Pizza pizza) throws JAXBException, IOException {
        //leer la carta
        Carta carta = leerXML();
        List<Pizza> pizzas = carta.getPizzas();

        //Buscar actualizar y añadir
        boolean encontrado = false;
        for(int i = 0; i< pizzas.size(); i++){
            if(pizzas.get(i).getId().equals(pizza.getId())){
                //pizza.set(i, pizza);
                encontrado = true;
                break;
            }
        }
        //Si no existe hay que añadirlo
        if(!encontrado){
            pizzas.add(pizza);
        }
        carta.setPizzas(pizzas);
        guardarXML(carta);
    }

    @Override
    public void exportarPizzasJSON(List<Pizza> pizzas) throws IOException {
                //no se implementa en XML (!!!!!!!!MIRAR PORQUE ¡¡¡¡¡¡¡¡)

        //Implementacion del JSON
        throw new UnsupportedOperationException("Use PizzaDAOJSONImpl para exportar JSON");
    }
}
