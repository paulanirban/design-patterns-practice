package com.practice.designpatterns.structural.facade.dataanalysis;

import com.practice.designpatterns.structural.facade.dataanalysis.models.*;
import com.practice.designpatterns.structural.facade.dataanalysis.services.AnalysisAlgorithmService;
import com.practice.designpatterns.structural.facade.dataanalysis.services.DataCollectionService;
import com.practice.designpatterns.structural.facade.dataanalysis.services.DataPreprocessingService;
import com.practice.designpatterns.structural.facade.dataanalysis.services.VisualizationService;

public class DataAnalysisManager {
    private final DataAnalysisFacade dataAnalysisFacade;

    public DataAnalysisManager(DataCollectionService dataCollectionService,
                               DataPreprocessingService dataPreprocessingService,
                               AnalysisAlgorithmService analysisAlgorithmService,
                               VisualizationService visualizationService) {
        this.dataAnalysisFacade = new DataAnalysisFacade(dataCollectionService, dataPreprocessingService, analysisAlgorithmService, visualizationService);
    }

    public AnalysisResult performFullAnalysis(DataCollectionParams collectionParams,
                                              PreprocessingOptions preprocessingOptions,
                                              AnalysisAlgorithmConfig algorithmConfig) {
        return this.dataAnalysisFacade.fullAnalysis(collectionParams, preprocessingOptions, algorithmConfig);
    }
}
