package com.tp3qualityrefactoring.app.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void testCoefValide() {
        double value = Validator.verifyNumeric("12.5");
        assertEquals(12.5, value);
    }

    @Test
    void testCoefInvalideAZero() {
        assertThrows(NumberFormatException.class, () -> Validator.verifyNumeric("0a"));
    }

    @Test
    void testSaisieNonNumerique() {
        Exception ex = assertThrows(NumberFormatException.class, () -> Validator.verifyNumeric("abc"));
        assertEquals("Erreur: Les valeurs doivent être numériques", ex.getMessage());
    }
}