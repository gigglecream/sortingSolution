package com.sort.solution.dao;

import com.sort.solution.model.SortEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jurijs.eizvertins on 30.May.17.
 */
@Transactional
@Repository
public class SortEntityDaoImpl implements SortEntityDao{

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<SortEntity> fetchAllSortEntities() {
        String hql = "FROM SortEntity as sr ORDER BY sr.id";
        return (List<SortEntity>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void clearAllSortEntities() {
        entityManager.createQuery("DELETE FROM SortEntity").executeUpdate();
    }

    @Override
    public void addSortEntity(SortEntity sortEntity) {
        entityManager.persist(sortEntity);
    }
}
