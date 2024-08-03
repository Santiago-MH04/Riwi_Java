package org.Santiago.JeffBezos.Simulacro2.models;

import java.time.LocalDate;

public class Vacancy {
        //Atributos de Vacancy
    private int id;
    private String title;
    private String description;
    private String technology;
    private status status;
    private LocalDate dor;
    private Company company;

        //Constructores de Vacancy
    public Vacancy() {}

        //Asignadores de atributos de Vacancy (setters)
    public void setId(int id) {
        this.id = id;
    }
        public void setTitle(String title) {
            this.title = title;
        }
            public void setDescription(String description) {
                this.description = description;
            }
                public void setTechnology(String technology) {
                    this.technology = technology;
                }
                    public void setStatus(status status) {
                        this.status = status;
                    }
                        public void setDor(LocalDate dor) {
                            this.dor = dor;
                        }
                            public void setCompany(Company company) {
                                this.company = company;
                            }

        //Lectores de atributos de Vacancy (getters)
    public int getId() {
        return this.id;
    }
        public String getTitle() {
            return this.title;
        }
            public String getDescription() {
                return this.description;
            }
                public String getTechnology() {
                    return this.technology;
                }
                    public status getStatus() {
                        return this.status;
                    }
                        public LocalDate getDor() {
                            return this.dor;
                        }
                            public Company getCompany() {
                                return this.company;
                            }

        //Métodos de Vacancy

    @Override
    public String toString() {
        return "Vacancy -> [" +
                "id=" + this.id +
                ", title='" + this.title + '\'' +
                ", description='" + this.description + '\'' +
                ", technology='" + this.technology + '\'' +
                ", status=" + this.status +
                ", dor=" + this.dor +
                ", company=" + this.company +
                ']';
    }
}
