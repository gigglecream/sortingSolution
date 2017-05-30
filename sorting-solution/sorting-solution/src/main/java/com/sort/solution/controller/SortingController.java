package com.sort.solution.controller;

import com.sort.solution.model.SortEntity;
import com.sort.solution.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jurijs.eizvertins on 30.May.17.
 */
@RestController
@RequestMapping("/result")
public class SortingController {

    @Autowired
    private SortingService sortingService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public SortEntity sort(@RequestBody Double[] numbers){
        Double[] numbersWithoutNulls = new Double[numbers.length];
        int j=-0;
        for(Double number : numbers) {
            if (number == null) {
                continue;
            }
            numbersWithoutNulls[j] = number;
            j++;
        }
        numbersWithoutNulls = Arrays.copyOfRange(numbersWithoutNulls, 0, j);
        return sortingService.createSortEntity(numbersWithoutNulls);
    }

    @RequestMapping(value = "/fetchAll", method = RequestMethod.GET)
    @ResponseBody
    public List<SortEntity> fetchAll() {
        return sortingService.fetchAllSortEntities();
    }

    @RequestMapping(value = "/clearAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void clearAll() {
        sortingService.clearAllSortEntities();
    }
}
