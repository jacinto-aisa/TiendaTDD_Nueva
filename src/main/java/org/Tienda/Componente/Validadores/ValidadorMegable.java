package org.Tienda.Componente.Validadores;

import org.Tienda.Componente.Caracteristicas.IMegable;

import java.util.function.Predicate;

public class ValidadorMegable implements Predicate<IMegable> {
    @Override
    public boolean test(IMegable iMegable) {
        return iMegable.dameAlmacenamiento() >= 0;
    }
}
