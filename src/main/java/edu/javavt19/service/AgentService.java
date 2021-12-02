package edu.javavt19.service;

import edu.javavt19.model2.hibernate.AgentModel;

import java.time.Month;
import java.util.TreeMap;

public interface AgentService extends GenericService<AgentModel> {
    TreeMap<AgentModel, Double> getSalary(Month month);
}
