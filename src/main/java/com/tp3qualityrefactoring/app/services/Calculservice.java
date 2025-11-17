package com.tp3qualityrefactoring.app.services;

import com.tp3qualityrefactoring.app.exceptions.InvalidCoefficientException;
import com.tp3qualityrefactoring.app.exceptions.NoRealRootException;

public class Calculservice {
    public String solveQuadraticVerbose(double a, double b, double c)
            throws InvalidCoefficientException, NoRealRootException {

        StringBuilder message = new StringBuilder();
        message.append("********** CALCULETTE SECOND DEGRE **********\n");
        message.append("Vous avez saisi : a=").append(a).append(" b=").append(b).append(" c=").append(c).append("\n");

        if (a == 0) {
            throw new InvalidCoefficientException("Coefficient 'a' ne peut pas être nul.");
        }

        double delta = (b * b) - (4 * a * c);
        message.append("Le discriminant (delta) vaut : ").append(delta).append("\n");

        if (delta == 0) {
            double x = (-b) / (2 * a);
            message.append("Il y a une seule solution : x = ").append(x).append("\n");
        } else if (delta > 0) {
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);
            message.append("Il y a deux solutions : x1 = ").append(x1).append(" x2 = ").append(x2).append("\n");
        } else {
            message.append("Pas de solutions réelles car delta < 0.\n");
            double partieReelle = -b / (2 * a);
            double partieImaginaire = Math.sqrt(-delta) / (2 * a);
            message.append("Solutions complexes :\n");
            message.append("x1 = ").append(partieReelle).append(" - i*").append(partieImaginaire).append("\n");

            message.append("x2 = ").append(partieReelle).append(" + i*").append(partieImaginaire).append("\n");
            throw new NoRealRootException("Pas de racines réelles.");
        }
        return message.toString();
    }
}
