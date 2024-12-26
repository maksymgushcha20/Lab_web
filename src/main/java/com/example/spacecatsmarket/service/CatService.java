package com.example.spacecatsmarket.service;

import com.example.spacecatsmarket.featuretoggle.CosmoCatsFeature;
import com.example.spacecatsmarket.featuretoggle.KittyProductsFeature;
import org.springframework.stereotype.Service;

@Service
public class CatService {

    @CosmoCatsFeature
    public void handleCosmoCats() {
        System.out.println("Handling CosmoCats...");
    }

    @KittyProductsFeature
    public void handleKittyProducts() {
        System.out.println("Handling KittyProducts...");
    }
}
