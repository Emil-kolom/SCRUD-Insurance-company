package edu.javavt19.service.hibernate;

import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model2.hibernate.AgentModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("agentService")
@Transactional(readOnly = false, value = "hibernateTransactionManager")
public class AgentServiceHibernateImpl extends GenericServiceHibernateImpl<AgentModel> {
    protected void setClazz(){
        hibernateDAO.setClazz(AgentModel.class);
    }
}
