package com.practice.designpatterns.structural.facade.dataanalysis.models;

import java.util.ArrayList;
import java.util.List;

public class DataCollectionResult {
    private List<Object> data = new ArrayList<>();
    public List<Object> getData() {
        return data;
    }
}
