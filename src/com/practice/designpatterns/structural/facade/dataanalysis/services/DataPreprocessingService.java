package com.practice.designpatterns.structural.facade.dataanalysis.services;

import com.practice.designpatterns.structural.facade.dataanalysis.models.PreprocessedData;
import com.practice.designpatterns.structural.facade.dataanalysis.models.PreprocessingOptions;

import java.util.List;

public class DataPreprocessingService {
    public PreprocessedData preprocessData(List<Object> rawData, PreprocessingOptions preprocessingOptions) {
        // Simulate data preprocessing process
        return new PreprocessedData();
    }
}
