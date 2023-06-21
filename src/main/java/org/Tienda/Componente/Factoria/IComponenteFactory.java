package org.Tienda.Componente.Factoria;

import org.Tienda.Componente.IComponenteIdentificable;
import org.Tienda.Componente.TipoComponente;

public interface IComponenteFactory {
    IComponenteIdentificable dameComponente(TipoComponente tipo, String num_Serie, double precio, double grados, double cores, double Almacenamiento);

}
