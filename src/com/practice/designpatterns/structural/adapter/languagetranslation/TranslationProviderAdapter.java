package com.practice.designpatterns.structural.adapter.languagetranslation;

import java.util.List;

public interface TranslationProviderAdapter {
    String doTranslate(TranslationRequest translationRequest);
    List<String> getSupportedLanguages();
}
