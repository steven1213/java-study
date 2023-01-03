package com.steven.java.spi.a;

import com.steven.java.spi.common.SpiInterface;

public class A implements SpiInterface {
    @Override
    public String search(String key) {
        return "A";
    }
}
