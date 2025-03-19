package com.back.ycar.cache;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class CacheStorage {
    private Map<String, Object> storage = new HashMap<>();

    public Object get(String key) {
        return storage.get(key);
    }

    public void put(String key, Object value) {
        storage.put(key, value);
    }

    public void remove(String key) {
        storage.remove(key);
    }
}
