package com.scenarioquestion.maplistconversion;

class Language {
    private String name;
    private int length;

    public Language(String name, int length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Language{name='" + name + "', length=" + length + "}";
    }
}
