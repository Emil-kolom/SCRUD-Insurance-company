package edu.javavt19.dao;

import edu.javavt19.model2.Model;
import java.util.List;

public interface GenericDAO<M extends Model> {
    void setClazz(Class<M> clazzToSet);
    void saveOrUpdate(M item);

    void delete(int itemId);

    M get(int itemId);

    List<M> list();
}
