package edu.javavt19.model2.hibernate;

import edu.javavt19.model2.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "contract")
@NamedQuery(name = "ContractModel.findAll", query = "select b from ContractModel b")
public class ContractModel implements Model, Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate date;

    @NotNull
    @Column
    private int sum_insured;

    @Column(insertable = false, updatable = false)
    private int insured_type;

    @ManyToOne //CASCADE - ....
    @JoinColumn(name = "insured_type")
    private InsuranceTypeModel insurance_type_model;

    @NotNull
    @Column(precision=4, scale=2)
    private Double tariff_rate;

    @Column(insertable = false, updatable = false)
    private int agent_id;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private AgentModel agent;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSum_insured() {
        return sum_insured;
    }

    public void setSum_insured(int sum_insured) {
        this.sum_insured = sum_insured;
    }

    public int getInsured_type() {
        return insured_type;
    }

    public void setInsured_type(int insured_type) {
        this.insured_type = insured_type;
    }

    public InsuranceTypeModel getInsurance_type_model() {
        return insurance_type_model;
    }

    public void setInsurance_type_model(InsuranceTypeModel insurance_type_model) {
        this.insurance_type_model = insurance_type_model;
    }

    public Double getTariff_rate() {
        return tariff_rate;
    }

    public void setTariff_rate(Double tariff_rate) {
        this.tariff_rate = tariff_rate;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public AgentModel getAgent() {
        return agent;
    }

    public void setAgent(AgentModel agent) {
        this.agent = agent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ContractModel{" +
                "id=" + id +
                ", date=" + date +
                ", sum_insured=" + sum_insured +
                ", insured_type=" + insured_type +
                ", insurance_type_name=" + insurance_type_model.getName() +
                ", tariff_rate=" + tariff_rate +
                ", agent_id=" + agent_id +
                ", agent firstName=" + agent.getFirstName() +
                '}';
    }
}
