package com.glosys.lms.spring;

import org.springframework.stereotype.Component;


public class Engine {
    private String engineType;

    public Engine(String engineType) {
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }
}
