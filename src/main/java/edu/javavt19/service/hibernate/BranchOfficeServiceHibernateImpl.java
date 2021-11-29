package edu.javavt19.service.hibernate;

import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model2.hibernate.AgentModel;
import edu.javavt19.model2.hibernate.BranchOfficeModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("branchService")
@Transactional(readOnly = false, value = "hibernateTransactionManager")
public class BranchOfficeServiceHibernateImpl extends GenericServiceHibernateImpl<BranchOfficeModel> {
    protected void setClazz(){
        hibernateDAO.setClazz(BranchOfficeModel.class);
    }
}
