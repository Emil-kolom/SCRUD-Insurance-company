package edu.javavt19.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "branch_office")
@NamedQuery(name = "insurance_type.findAll", query = "select c from BranchOfficeModel c")
public class BranchOfficeModel {
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    //не допускает пустые значения, но может быть пуст
    @NotNull
    @Size(max=512)
    @Column(unique=true, nullable=false)
    private String name;


    @Size(max=512)
    @Column
    private String address;

    @Size(max=15)
    @Column
    private String phoneNumber;

    public BranchOfficeModel(){}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return "BranchOffice{ " +
                "id= " + id+
                ", name= " + name+
                ", address= "+ address+
                ", phoneNumber= "+ phoneNumber +"}";
    }
}