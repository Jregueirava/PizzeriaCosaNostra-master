package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType
    public class IngredienteRef {

        private static final long serialVersionUID = 1L;

        private String id;

        public IngredienteRef() { } // JAXB necesita constructor sen parámetros

        public IngredienteRef(String id) {
            this.id = id;
        }

        @XmlAttribute(name= "ID")
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return this.getId();
        }
    }
