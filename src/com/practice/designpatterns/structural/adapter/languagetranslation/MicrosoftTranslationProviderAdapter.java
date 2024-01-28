package com.practice.designpatterns.structural.adapter.languagetranslation;

import com.practice.designpatterns.structural.adapter.languagetranslation.external.MicrosoftTranslateApi;

import java.util.List;

public class MicrosoftTranslationProviderAdapter implements TranslationProviderAdapter {
    MicrosoftTranslateApi api = new MicrosoftTranslateApi();
    @Override
    public String doTranslate(TranslationRequest translationRequest) {
        return api.translate(translationRequest.text, translationRequest.sourceLanguage, translationRequest.targetLanguage);
    }

    @Override
    public List<String> getSupportedLanguages() {
        return api.getSupportedLanguages();
    }
}
