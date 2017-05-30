package com.sort.solution.logic;

import com.sort.solution.model.SortEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by jurijs.eizvertins on 30.May.17.
 */
public class Sorter {
    private final int lenght;
    private Double[] numbersAsArray;
    private double max;
    private double min;

    public Sorter(Double[] numbersAsArray){
        this.numbersAsArray = numbersAsArray;
        this.lenght = numbersAsArray.length;
    }

    public SortEntity sort(){
        List<Double> arrayAsList = Arrays.asList(this.numbersAsArray);
        max = Collections.max(arrayAsList);
        min = Collections.min(arrayAsList);

        int firstIndex, secondIndex;
        double firtNumber, secondNumber;
        long timeEstimatedNs = System.nanoTime();
        int changeCount = 0;
        Random random = new Random();

        while(!arrayIsSorted()) {
            firstIndex = random.nextInt(lenght);
            secondIndex = random.nextInt(lenght);

            if (secondIndex == firstIndex) {
                secondIndex = (firstIndex == lenght - 1) ? secondIndex -1 : secondIndex +1;
            }

            firtNumber = numbersAsArray[firstIndex];
            secondNumber = numbersAsArray[secondIndex];

            boolean firstIndexLessThanFirstNumber = (firstIndex < secondIndex) && (firtNumber > secondNumber);
            boolean firstIndexGreaterThanFirstNumber = (firstIndex > secondIndex) && (firtNumber < secondNumber);

            if(firstIndexLessThanFirstNumber || firstIndexGreaterThanFirstNumber) {
                numbersAsArray[firstIndex] = secondNumber;
                numbersAsArray[secondIndex] = firtNumber;
                changeCount++;
            }
        }
        timeEstimatedNs = System.nanoTime() - timeEstimatedNs;

        String timeEstimate = adjustTime(timeEstimatedNs);
        return new SortEntity(Arrays.toString(numbersAsArray), changeCount, timeEstimate);
    }

    private String adjustTime(long timeEstimatedNs) {
        if (timeEstimatedNs < 1000000) {
            return timeEstimatedNs + "ns";
        }
        if (timeEstimatedNs >= 1000000 && timeEstimatedNs < 1000000000) {
            return timeEstimatedNs + "ms";
        }
        if (timeEstimatedNs >= 1000000000 && timeEstimatedNs < 60000000000L) {
            return timeEstimatedNs + "s";
        }
        if (timeEstimatedNs >= 60000000000L && timeEstimatedNs < 3600000000000L) {
            return timeEstimatedNs + "min";
        }
        return timeEstimatedNs/3600000000000L + "hours";
    }

    private boolean arrayIsSorted() {
        if (this.numbersAsArray[0] != this.min || this.numbersAsArray[this.lenght - 1] != this.max) {
            return false;
        }

        for (int i = 1; i < this.lenght -1; i++) {
            if (this.numbersAsArray[i] < this.numbersAsArray[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
