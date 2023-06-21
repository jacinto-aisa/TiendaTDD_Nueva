package org.Tienda.Componente.Validadores;
import org.Tienda.Componente.IComponenteIdentificable;

import java.util.function.Predicate;
public class ValidadorComponente implements Predicate<IComponenteIdentificable>{

    @Override
    public boolean test(IComponenteIdentificable iComponenteIdentificable) {
        if (iComponenteIdentificable.dameSerie().equals("") ||
                iComponenteIdentificable.dameTipo() == null ||
                iComponenteIdentificable.damePrecio() < 0 ||
                iComponenteIdentificable.dameGrados() < 0)
            return false;
        else
            return true;
    }
}
