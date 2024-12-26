package com.example.spacecatsmarket.featuretoggle;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FeatureToggleAspect {

    private final FeatureToggleService featureToggleService;

    public FeatureToggleAspect(FeatureToggleService featureToggleService) {
        this.featureToggleService = featureToggleService;
    }

    @Before("@annotation(CosmoCatsFeature)")
    public void checkCosmoCatsFeature() {
        if (!featureToggleService.isCosmoCatsEnabled()) {
            throw new FeatureNotAvailableException("CosmoCats feature is disabled!");
        }
    }

    @Before("@annotation(KittyProductsFeature)")
    public void checkKittyProductsFeature() {
        if (!featureToggleService.isKittyProductsEnabled()) {
            throw new FeatureNotAvailableException("KittyProducts feature is disabled!");
        }
    }
}
