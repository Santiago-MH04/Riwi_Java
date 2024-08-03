package org.Santiago.JeffBezos.Simulacro2.models;

public class Coder {
        //Atributos de Coder
    private int id;
    private String doi;
    private String name;
    private String lastName;
    private String clan;
    private String technology;

        //Constructores de Coder
    public Coder() {}

        //Asignadores de atributos de Coder (setters)
    public void setId(int id) {
        this.id = id;
    }
        public void setDoi(String doi) {
            this.doi = doi;
        }
            public void setName(String name) {
                this.name = name;
            }
                public void setLastName(String lastName) {
                    this.lastName = lastName;
                }
                    public void setClan(String clan) {
                        this.clan = clan;
                    }
                        public void setTechnology(String technology) {
                            this.technology = technology;
                        }

        //Lectores de atributos de Coder (getters)
    public int getId() {
        return this.id;
    }
        public String getDoi() {
            return this.doi;
        }
            public String getName() {
                return this.name;
            }
                public String getLastName() {
                    return this.lastName;
                }
                    public String getClan() {
                        return this.clan;
                    }
                        public String getTechnology() {
                            return this.technology;
                        }

        //Métodos de Coder
    @Override
    public String toString() {
        return "Coder -> [" +
                "id: " + this.id +
                ". DOI: " + this.doi +
                ". Name: " + this.name +
                ". Last name: " + this.lastName +
                ". Clan: " + this.clan +
                ". Technology: " + this.technology + ']';
    }
}
