package com.steven.design.pattern.creational.singleton;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class LazyInstance {
    private static LazyInstance obj;

    private LazyInstance() {
    }

    public static LazyInstance getInstance() {
        if (Objects.isNull(obj)) {
            synchronized (LazyInstance.class) {
                if (Objects.isNull(obj)) {
                    obj = new LazyInstance();
                }
            }

        }
        return obj;
    }

    public void doSomething() {
        log.info("lazy instance do something");
    }

    public Object readResolve() {
        return getInstance();
    }
}
