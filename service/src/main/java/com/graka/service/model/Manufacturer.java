package com.graka.service.model;

public enum Manufacturer {
    Intel(0),AMD(1),nvidia(2);

    private final int value;

     Manufacturer(int value) {
        this.value = value;
    }

    public int getValueCode() {
        return this.value;
    }
}

//Level level = Level.HIGH;
//
//System.out.println(level.getLevelCode());