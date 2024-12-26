package com.example.spacecatsmarket.featuretoggle;

import com.example.spacecatsmarket.service.CosmoCatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class FeatureToggleTest {

    @Autowired
    private CosmoCatService cosmoCatService;

    @Autowired
    private FeatureToggleService featureToggleService;

    @Test
    void testCosmoCatsFeatureEnabled() {
        if (featureToggleService.isCosmoCatsEnabled()) {
            String result = cosmoCatService.getCosmoCats();
            assertEquals("List of CosmoCats from the galaxy!", result);
        }
    }

    @Test
    void testCosmoCatsFeatureDisabled() {
        if (!featureToggleService.isCosmoCatsEnabled()) {
            assertThrows(FeatureNotAvailableException.class, () -> cosmoCatService.getCosmoCats());
        }
    }
}
