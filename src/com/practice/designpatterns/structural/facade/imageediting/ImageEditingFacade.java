package com.practice.designpatterns.structural.facade.imageediting;

import com.practice.designpatterns.structural.facade.imageediting.models.Image;
import com.practice.designpatterns.structural.facade.imageediting.services.*;

public class ImageEditingFacade {
    private final ImageLoader imageLoader;
    private final FilterService filterService;
    private final ImageModifier imageModifier;
    private final ImageWriter imageWriter;
    private final AnalyticsService analyticsService;

    public ImageEditingFacade(ImageLoader imageLoader, FilterService filterService, ImageModifier imageModifier, ImageWriter imageWriter, AnalyticsService analyticsService) {
        this.imageLoader = imageLoader;
        this.filterService = filterService;
        this.imageModifier = imageModifier;
        this.imageWriter = imageWriter;
        this.analyticsService = analyticsService;
    }

    public void editImage(String imagePath, String filterType, int brightness) {
        Image image = imageLoader.loadImage(imagePath);

        filterService.applyFilter(image, filterType);
        imageModifier.adjustBrightness(image, brightness);

        imageWriter.saveImage(image);
        analyticsService.store(image);
    }
}
