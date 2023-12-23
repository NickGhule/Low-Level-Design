package com.programmingplanet.lld.designpatterns.creational.Registry;

import java.util.HashMap;

import com.programmingplanet.lld.designpatterns.creational.Prototype.BackgroundObjectType;
import com.programmingplanet.lld.designpatterns.creational.Prototype.BackgroundObject;

public class BackgroundObjectRegistry {
    private HashMap<BackgroundObjectType, BackgroundObject> registry = new HashMap<>();

    public BackgroundObjectRegistry() {
    
    }

    public BackgroundObject getBackgroundObject(BackgroundObjectType type) {
        return registry.get(type);
    }

    public void putBackgroundObject(BackgroundObjectType type, BackgroundObject backgroundObject) {
        registry.put(type, backgroundObject);
    }
}
