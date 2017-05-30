package com.sort.solution.dao;

import com.sort.solution.model.SortEntity;

import java.util.List;

/**
 * Created by jurijs.eizvertins on 30.May.17.
 */
public interface SortEntityDao {

    List<SortEntity> fetchAllSortEntities();
    void clearAllSortEntities();

    void addSortEntity(SortEntity sortEntity);
}
