package com.practice.designpatterns.structural.adapter.languagetranslation;

import com.practice.designpatterns.structural.adapter.languagetranslation.external.GoogleTranslateApi;
import com.practice.designpatterns.structural.adapter.languagetranslation.external.GoogleTranslationRequest;

import java.util.List;

public class GoogleTranslationProviderAdapter implements TranslationProviderAdapter {
    GoogleTranslateApi api = new GoogleTranslateApi();
    @Override
    public String doTranslate(TranslationRequest translationRequest) {
        return api.convert(toGoogleTranslationReq(translationRequest));
    }

    private static GoogleTranslationRequest toGoogleTranslationReq(TranslationRequest translationRequest) {
        return new GoogleTranslationRequest(translationRequest.text, translationRequest.sourceLanguage, translationRequest.targetLanguage, translationRequest.confidenceThreshold);
    }

    @Override
    public List<String> getSupportedLanguages() {
        return api.getLanguages();
    }
}
