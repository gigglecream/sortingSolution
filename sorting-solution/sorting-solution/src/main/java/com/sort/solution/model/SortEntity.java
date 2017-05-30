package com.sort.solution.model;

import javax.persistence.*;

/**
 * Created by jurijs.eizvertins on 30.May.17.
 */
@Entity
public class SortEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String sortedArray;

    @Column
    private int changeCount;

    @Column
    private String timeEstimate;

    public SortEntity(){}

    public SortEntity(String sortedArray, int changeCount, String timeEstimate){
        this.sortedArray = sortedArray;
        this.changeCount = changeCount;
        this.timeEstimate = timeEstimate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(String sortedArray) {
        this.sortedArray = sortedArray;
    }

    public int getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public String getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(String timeEstimate) {
        this.timeEstimate = timeEstimate;
    }
}
