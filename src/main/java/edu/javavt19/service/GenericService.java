package edu.javavt19.service;

import edu.javavt19.model.Model;
import java.util.List;

public interface GenericService <M extends Model> {
    void saveOrUpdate(M item);

    void delete(int itemId);

    M get(int itemId);

    List<M> list();
}
