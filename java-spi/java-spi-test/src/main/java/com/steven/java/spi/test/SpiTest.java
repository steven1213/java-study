package com.steven.java.spi.test;

import com.steven.java.spi.common.SpiInterface;

import java.util.ServiceLoader;

public class SpiTest {
    public static void main(String[] args) {

        ServiceLoader<SpiInterface> serverLoader = ServiceLoader.load(SpiInterface.class);
        serverLoader.forEach(provider->{
            String hello = provider.search("hello");
            System.out.println(hello);
        });
    }
}
