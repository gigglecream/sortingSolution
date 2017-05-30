package com.sort.solution.service;

import com.sort.solution.model.SortEntity;

import java.util.List;

/**
 * Created by jurijs.eizvertins on 30.May.17.
 */
public interface SortingService {

    List<SortEntity> fetchAllSortEntities();
    void clearAllSortEntities();

    SortEntity createSortEntity(Double[] array);
}
