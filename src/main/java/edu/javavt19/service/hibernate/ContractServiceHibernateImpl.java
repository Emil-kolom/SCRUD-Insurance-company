package edu.javavt19.service.hibernate;

import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model2.hibernate.AgentModel;
import edu.javavt19.model2.hibernate.ContractModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contractService")
@Transactional(readOnly = false, value = "hibernateTransactionManager")
public class ContractServiceHibernateImpl extends GenericServiceHibernateImpl<ContractModel> {
    protected void setClazz(){
        hibernateDAO.setClazz(ContractModel.class);
    }
}
