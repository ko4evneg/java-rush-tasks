package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        AnyObject o = softReference == null ? null : softReference.get();
        return o;
    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        AnyObject result = softReference == null ? null : softReference.get();
        if (softReference != null)
            softReference.clear();
        cacheMap.put(key, new SoftReference<>(value));
        return result;
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        AnyObject result = softReference == null ? null : softReference.get();
        if (softReference != null)
            softReference.clear();
        return result;
    }
}