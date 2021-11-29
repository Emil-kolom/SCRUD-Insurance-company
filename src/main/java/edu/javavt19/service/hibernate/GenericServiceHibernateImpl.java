package edu.javavt19.service.hibernate;

import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model2.Model;
import edu.javavt19.model2.hibernate.AgentModel;
import edu.javavt19.model2.hibernate.BranchOfficeModel;
import edu.javavt19.model2.hibernate.ContractModel;
import edu.javavt19.model2.hibernate.InsuranceTypeModel;
import edu.javavt19.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=false, value = "hibernateTransactionManager")
public class GenericServiceHibernateImpl<M extends Model> implements GenericService<M> {
    @Autowired
    protected GenericHibernateImpl<M> hibernateDAO;

    protected void setClazz(){}

    public void saveOrUpdate(M item){
        setClazz();
        hibernateDAO.saveOrUpdate(item);
    }

    public void delete(int itemId){
        setClazz();
        hibernateDAO.delete(itemId);
    }

    public M get(int itemId){
        setClazz();
        return hibernateDAO.get(itemId);
    }

    public List<M> list(){
        setClazz();
        return hibernateDAO.list();
    }
}

