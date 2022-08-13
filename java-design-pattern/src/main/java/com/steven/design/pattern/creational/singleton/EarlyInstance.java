package com.steven.design.pattern.creational.singleton;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public class EarlyInstance implements Serializable {

    private static EarlyInstance obj = new EarlyInstance();

    private EarlyInstance() {
    }

    public static EarlyInstance getInstance() {
        return obj;
    }

    public void doSomething() {
        log.info("early instance do something");
    }

    protected Object readResolve() {
        return getInstance();
    }
}
