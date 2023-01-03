package com.steven.java.spi.b;

import com.steven.java.spi.common.SpiInterface;

public class B implements SpiInterface {
    @Override
    public String search(String key) {
        return "B";
    }
}
