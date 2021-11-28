package edu.javavt19.service.hibernate;

import edu.javavt19.dao.GenericDAO;
import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model.Model;
import edu.javavt19.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("genericService")
@Transactional(readOnly=false, value = "hibernateTransactionManager")
public class GenericServiceHibernateImpl<M extends Model> implements GenericService<M> {
    @Autowired
    private GenericHibernateImpl<M> hibernateDAO;

    public void saveOrUpdate(M item){
        hibernateDAO.saveOrUpdate(item);
    }

    public void delete(int itemId){
        hibernateDAO.delete(itemId);
    }

    public M get(int itemId){
        return hibernateDAO.get(itemId);
    }

    public List<M> list(){
        return hibernateDAO.list();
    }
}
