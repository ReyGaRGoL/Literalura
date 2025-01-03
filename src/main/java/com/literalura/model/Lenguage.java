package com.literalura.model;

public enum Lenguage {

	es("es"),
    en("en"),
    fr("fr"),
    pt("pt");

    private String lenguaje;

    private Lenguage(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public static Lenguage fromString(String text) {
        for (Lenguage lenguage : Lenguage.values()) {
            if (lenguage.lenguaje.equalsIgnoreCase(text)) {
                return lenguage;
            }
        }
        return null;
    }
}
