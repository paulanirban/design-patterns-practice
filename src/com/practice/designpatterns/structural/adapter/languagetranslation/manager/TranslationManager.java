package com.practice.designpatterns.structural.adapter.languagetranslation.manager;

import com.practice.designpatterns.structural.adapter.languagetranslation.external.GoogleTranslateApi;
import com.practice.designpatterns.structural.adapter.languagetranslation.external.GoogleTranslationRequest;
import com.practice.designpatterns.structural.adapter.languagetranslation.external.MicrosoftTranslateApi;

public class TranslationManager {
    private GoogleTranslateApi googleTranslateApi = new GoogleTranslateApi();
    private MicrosoftTranslateApi microsoftTranslateApi = new MicrosoftTranslateApi();

    public String translate(String text, String sourceLanguage, String targetLanguage, String provider) {

        if (provider.equals("google")) {
            GoogleTranslationRequest request = new GoogleTranslationRequest(text, sourceLanguage, targetLanguage, 0.8);
            return googleTranslateApi.convert(request);
        } else if (provider.equals("microsoft")) {
            return microsoftTranslateApi.translate(text, sourceLanguage, targetLanguage);
        } else {
            throw new RuntimeException("Invalid provider");
        }
    }
}
