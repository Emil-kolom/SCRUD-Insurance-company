package edu.javavt19.dao.hibernate;

import com.google.common.base.Preconditions;
import edu.javavt19.dao.GenericDAO;
import edu.javavt19.model.Model;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GenericHibernateImpl<M extends Model> implements GenericDAO<M> {
    @Autowired
    private SessionFactory sessionFactory;
    private Class<M> clazz;

    public void setClazz(final Class<M> clazzToSet) {
        clazz = Preconditions.checkNotNull(clazzToSet);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(M item) {
        if (item.getId() > 0) {
            //update
            getCurrentSession().merge(item);
        } else {
            //insert
            getCurrentSession().save(item);
        }

    }

    public void delete(int itemId) {
        M model = get(itemId);
        if (model != null)
            getCurrentSession().delete(model);
    }

    public M get(int itemId) {
        M model = (M) getCurrentSession().get(clazz, itemId);

        return model;
    }

    public List<M> list() {
        Criteria criteria = getCurrentSession().createCriteria(clazz);

        return criteria.list();
    }
}