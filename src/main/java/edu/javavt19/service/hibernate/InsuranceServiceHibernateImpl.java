package edu.javavt19.service.hibernate;

import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model2.hibernate.AgentModel;
import edu.javavt19.model2.hibernate.InsuranceTypeModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("typeService")
@Transactional(readOnly = false, value = "hibernateTransactionManager")
public class InsuranceServiceHibernateImpl extends GenericServiceHibernateImpl<InsuranceTypeModel> {
    protected void setClazz(){
        hibernateDAO.setClazz(InsuranceTypeModel.class);
    }
}
