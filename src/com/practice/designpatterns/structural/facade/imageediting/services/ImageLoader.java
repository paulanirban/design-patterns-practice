package com.practice.designpatterns.structural.facade.imageediting.services;

import com.practice.designpatterns.structural.facade.imageediting.models.Image;

public class ImageLoader {
    public Image loadImage(String imagePath) {
        return new Image();
    }
}
