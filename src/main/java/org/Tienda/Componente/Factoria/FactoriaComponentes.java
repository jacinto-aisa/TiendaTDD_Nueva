package org.Tienda.Componente.Factoria;

import org.Tienda.Componente.*;
import org.Tienda.Componente.Caracteristicas.*;
import org.Tienda.Componente.Validadores.ValidadorComponente;
import org.Tienda.Componente.Validadores.ValidadorCores;
import org.Tienda.Componente.Validadores.ValidadorMegable;

public class FactoriaComponentes implements IComponenteFactory {

    @Override
    public IComponenteIdentificable dameComponente(TipoComponente tipo, String num_Serie, double precio, double grados, double cores, double Almacenamiento) {
        ICoreable Cores = null;
        if (cores  == 0) {
            Cores = new SinCores();
        }
        else
        {
            Cores = new ConCores(cores);
            if (!new ValidadorCores().test(Cores)) {
                return null;
            }
        }

        IMegable Almacen = null;
        if (Almacenamiento == 0)
        {
            Almacen = new SinMegas();
        }
        else {
            Almacen = new ConMegas(Almacenamiento);
            if (!new ValidadorMegable().test(Almacen)) {
                return null;
            }
        }
        Componente miComponente = new Componente(tipo,num_Serie,precio,grados,
                Cores,Almacen);
        if (new ValidadorComponente().test(miComponente))
            return miComponente;
        else
            return null;
    }
}
