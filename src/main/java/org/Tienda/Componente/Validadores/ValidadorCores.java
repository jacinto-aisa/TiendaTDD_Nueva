package org.Tienda.Componente.Validadores;
import org.Tienda.Componente.Caracteristicas.ICoreable;

import java.util.function.Predicate;


public class ValidadorCores implements Predicate<ICoreable> {
    @Override
    public boolean test(ICoreable iCoreable) {
        return iCoreable.dameCores() >= 0;
    }
}
