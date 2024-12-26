package com.example.spacecatsmarket.featuretoggle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FeatureToggleService {

    @Value("${application.feature.toggles.cosmoCats}")
    private boolean cosmoCatsEnabled;

    @Value("${application.feature.toggles.kittyProducts}")
    private boolean kittyProductsEnabled;

    public boolean isCosmoCatsEnabled() {
        return cosmoCatsEnabled;
    }

    public boolean isKittyProductsEnabled() {
        return kittyProductsEnabled;
    }
}
