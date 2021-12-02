package edu.javavt19.service.hibernate;

import edu.javavt19.model2.hibernate.AgentModel;
import edu.javavt19.model2.hibernate.BranchOfficeModel;
import edu.javavt19.model2.hibernate.ContractModel;
import edu.javavt19.service.AgentService;
import edu.javavt19.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.TreeMap;

@Service("agentService")
@Transactional(readOnly = false, value = "hibernateTransactionManager")
public class AgentServiceHibernateImpl extends GenericServiceHibernateImpl<AgentModel> implements AgentService {
    @Autowired
    @Qualifier("contractService")
    private GenericService<ContractModel> contractService;

    protected void setClazz(){
        hibernateDAO.setClazz(AgentModel.class);
    }


    /*
     * 1) получить всех агентов заключивших контракт в этом месяце
     * 2) рассчитать для каждого зп по карте - id, Double.
     * */
    public TreeMap<AgentModel, Double> getSalary(Month month){
        TreeMap<AgentModel, Double> salaryMap = new TreeMap<>();
        List<ContractModel> contractList = contractService.list();
        for(var contract: contractList){
            if(contract.getDate().getMonth().equals(month)) {
                Double prevSalary = salaryMap.get(contract.getAgent());
                //расчет зарплаты с текущего контракта
                Double curSalary = (contract.getSum_insured() * (contract.getTariff_rate()/100D)) *
                        (contract.getInsurance_type_model().getAgent_percentage() / 100D);
                /*
                Заробітна плата
складає деякий відсоток від страхового платежу (страховий платіж - це страхова
сума, помножена на тарифну ставку (tariff_rate)).
                * */
                if(prevSalary != null) {
                    curSalary += prevSalary;
                }
                salaryMap.put(contract.getAgent(), curSalary);
            }
        }
        return  salaryMap;
    }
}
