package edu.javavt19.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "agent")
@NamedQuery(name = "insurance_type.findAll", query = "select c from BranchOfficeModel c")
public class AgentModel implements Model, Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Size(max=256)
    @NotEmpty
    @Column
    private String firstName;

    @NotEmpty
    @Size(max=256)
    @Column
    private String secondName;

    @NotEmpty
    @Size(max=256)
    @Column
    private String patronymic;

    @Size(max=512)
    @Column
    private String address;

    @Size(max=15)
    @Column
    private String phoneNumber;

    @Column(insertable = false, updatable = false)
    private int branch_office_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "officeId")
    private BranchOfficeModel officeModel;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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

    public BranchOfficeModel getOfficeModel() {
        return officeModel;
    }

    public void setOfficeModel(BranchOfficeModel officeModel) {
        this.officeModel = officeModel;
    }

    public int getBranch_office_id() {
        return branch_office_id;
    }

    public void setBranch_office_id(int officeId) {
        this.branch_office_id = officeId;
    }

    @Override
    public String toString(){
        return "Agent{ " +
                "id= " + id+
                ", fistName= " + firstName+
                ", secondName= " + secondName+
                ", patronymic= " + patronymic+
                ", address= "+ address+
                ", phoneNumber= "+ phoneNumber +
                ", officeName= "+ officeModel.getName()+
                ", officeId= " + branch_office_id
                + "}";
    }
}
