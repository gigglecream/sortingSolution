package com.sort.solution.service;

import com.sort.solution.dao.SortEntityDao;
import com.sort.solution.logic.Sorter;
import com.sort.solution.model.SortEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jurijs.eizvertins on 30.May.17.
 */
@Service
public class SortingServiceImpl implements SortingService{

    @Autowired
    private SortEntityDao sortEntityDao;

    public List<SortEntity> fetchAllSortEntities() {
        return sortEntityDao.fetchAllSortEntities();
    }

    public void clearAllSortEntities() {
        sortEntityDao.clearAllSortEntities();
    }

    public SortEntity createSortEntity(Double[] numbers) {
        Sorter sorter = new Sorter(numbers);
        SortEntity sortEntity = sorter.sort();
        sortEntityDao.addSortEntity(sortEntity);
        return sortEntity;
    }
}
