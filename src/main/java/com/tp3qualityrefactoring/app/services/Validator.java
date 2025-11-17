package com.tp3qualityrefactoring.app.services;

public final class Validator {

    private Validator() {
    }

    public static double verifyNumeric(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw  new NumberFormatException("Erreur: Les valeurs doivent être numériques");
        }
    }
}
