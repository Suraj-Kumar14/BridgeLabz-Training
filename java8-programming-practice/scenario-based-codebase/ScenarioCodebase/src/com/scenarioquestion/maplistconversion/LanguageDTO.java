package com.scenarioquestion.maplistconversion;

class LanguageDTO {
    private String name;
    private int length;

    public LanguageDTO(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() { return name; }
    public int getLength() { return length; }

    @Override
    public String toString() {
        return "LanguageDTO{name='" + name + "', length=" + length + "}";
    }
}
