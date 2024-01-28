package com.practice.designpatterns.structural.facade.dataanalysis;

import com.practice.designpatterns.structural.facade.dataanalysis.models.*;
import com.practice.designpatterns.structural.facade.dataanalysis.services.AnalysisAlgorithmService;
import com.practice.designpatterns.structural.facade.dataanalysis.services.DataCollectionService;
import com.practice.designpatterns.structural.facade.dataanalysis.services.DataPreprocessingService;
import com.practice.designpatterns.structural.facade.dataanalysis.services.VisualizationService;

public class DataAnalysisFacade {
    private final DataCollectionService dataCollectionService;
    private final DataPreprocessingService dataPreprocessingService;
    private final AnalysisAlgorithmService analysisAlgorithmService;
    private final VisualizationService visualizationService;

    public DataAnalysisFacade(DataCollectionService dataCollectionService, DataPreprocessingService dataPreprocessingService, AnalysisAlgorithmService analysisAlgorithmService, VisualizationService visualizationService) {
        this.dataCollectionService = dataCollectionService;
        this.dataPreprocessingService = dataPreprocessingService;
        this.analysisAlgorithmService = analysisAlgorithmService;
        this.visualizationService = visualizationService;
    }

    public AnalysisResult fullAnalysis(DataCollectionParams collectionParams,
                                       PreprocessingOptions preprocessingOptions,
                                       AnalysisAlgorithmConfig algorithmConfig) {
        DataCollectionResult collectionResult = dataCollectionService.collectData(collectionParams);
        PreprocessedData preprocessedData = dataPreprocessingService.preprocessData(collectionResult.getData(), preprocessingOptions);
        AnalysisResult analysisResult = analysisAlgorithmService.applyAnalysisAlgorithms(preprocessedData, algorithmConfig);
        visualizationService.visualizeResults(analysisResult);

        return analysisResult;

    }
}
