package com.example.spacecatsmarket.service;

import com.example.spacecatsmarket.featuretoggle.CosmoCatsFeature;
import org.springframework.stereotype.Service;

@Service
public class CosmoCatService {

    @CosmoCatsFeature
    public String getCosmoCats() {
        return "List of CosmoCats from the galaxy!";
    }
}
