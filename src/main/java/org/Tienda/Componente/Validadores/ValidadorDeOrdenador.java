package org.Tienda.Componente.Validadores;


import org.Tienda.Componente.TipoComponente;
import org.Tienda.Ordenador.Ordenador;

import java.util.function.Predicate;

public class ValidadorDeOrdenador implements Predicate<Ordenador> {
    @Override
    public boolean test(Ordenador ordenador) {
        return (ordenador.getPiezas().values().stream().filter(p->p.dameTipo()== TipoComponente.Almacenamiento).count()==1 &&
                ordenador.getPiezas().values().stream().filter(p->p.dameTipo()==TipoComponente.Procesador).count()==1 &&
                ordenador.getPiezas().values().stream().filter(p->p.dameTipo()==TipoComponente.Memoria).count()==1);
    }
}
