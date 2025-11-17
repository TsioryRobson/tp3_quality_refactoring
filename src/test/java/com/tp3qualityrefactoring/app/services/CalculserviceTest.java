package com.tp3qualityrefactoring.app.services;

import com.tp3qualityrefactoring.app.exceptions.NoRealRootException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculserviceTest {
    Calculservice service = new Calculservice();

    @Test
    void testCalculDiscriminantCasSimple() throws Exception {
        // a=1, b=5, c=6 -> delta = 1
        String result = service.solveQuadraticVerbose(1, 5, 6);
        assertTrue(result.contains("Le discriminant (delta) vaut : 1.0"));
    }

    @Test
    void testCalculDiscriminantZero() throws Exception {
        // a=1, b=2, c=1 -> delta = 0
        String result = service.solveQuadraticVerbose(1, 2, 1);
        assertTrue(result.contains("Le discriminant (delta) vaut : 0.0"));
        assertTrue(result.contains("Il y a une seule solution"));
    }

    @Test
    void testCalculDiscriminantNegatif() {
        // a=1, b=0, c=1 -> delta = -4
        assertThrows(NoRealRootException.class, () -> service.solveQuadraticVerbose(1, 0, 1));
    }

    @Test
    void testSolutionsDeuxRacines() throws Exception {
        // a=1, b=3, c=2 -> solutions : -1 et -2
        String result = service.solveQuadraticVerbose(1, 3, 2);
        assertTrue(result.contains("Il y a deux solutions"));
        assertTrue(result.contains("x1 = -2.0"));
        assertTrue(result.contains("x2 = -1.0"));
    }

    @Test
    void testSolutionsRacineDouble() throws Exception {
        // a=1, b=2, c=1 -> solution : -1
        String result = service.solveQuadraticVerbose(1, 2, 1);
        assertTrue(result.contains("Il y a une seule solution"));
        assertTrue(result.contains("x = -1.0"));
    }
}