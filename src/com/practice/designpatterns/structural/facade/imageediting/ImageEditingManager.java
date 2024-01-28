package com.practice.designpatterns.structural.facade.imageediting;

import com.practice.designpatterns.structural.facade.imageediting.services.*;

public class ImageEditingManager {
    private final ImageEditingFacade imageEditingFacade;

    public ImageEditingManager(ImageLoader imageLoader, FilterService filterService, ImageModifier imageModifier, ImageWriter imageWriter, AnalyticsService analyticsService) {
        imageEditingFacade = new ImageEditingFacade(imageLoader, filterService, imageModifier, imageWriter, analyticsService);
    }

    public void editImage(String imagePath, String filterType, int brightness) {
        imageEditingFacade.editImage(imagePath, filterType, brightness);
    }
}
