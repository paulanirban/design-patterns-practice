package com.practice.designpatterns.structural.adapter.languagetranslation;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TranslationRequest {
    String text;
    String sourceLanguage;
    String targetLanguage;
    Double confidenceThreshold;
}
