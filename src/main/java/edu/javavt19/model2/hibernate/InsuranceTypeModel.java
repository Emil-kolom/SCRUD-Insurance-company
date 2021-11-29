package edu.javavt19.model2.hibernate;

import edu.javavt19.model2.Model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "insurance_type")
@NamedQuery(name = "InsuranceTypeModel.findAll", query = "select d from InsuranceTypeModel d")
public class InsuranceTypeModel implements Model, Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Size(max=256)
    @Column(unique=true, nullable=false)
    private String name;

    @NotNull
    @Column(precision=4, scale=2)
    private Double agent_percentage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAgent_percentage() {
        return agent_percentage;
    }

    public void setAgent_percentage(Double agent_percentage) {
        this.agent_percentage = agent_percentage;
    }

    @Override
    public String toString(){
        return "InsuranceTypeModel={" +
                "id= "+ id +
                ", name= " + name+
                ", agent percentage = " + agent_percentage+
                "}";
    }
}
