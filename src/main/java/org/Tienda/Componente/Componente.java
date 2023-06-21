package org.Tienda.Componente;

import org.Tienda.Componente.Caracteristicas.ICoreable;
import org.Tienda.Componente.Caracteristicas.IMegable;

public class Componente implements IComponenteIdentificable {
    private final TipoComponente tipo;
    private final String num_Serie;
    private final double precio;
    private final double grados;
    public final ICoreable Cores;
    public final IMegable Almacenamiento;

    public Componente(TipoComponente tipo, String num_Serie, double precio, double grados, ICoreable cores, IMegable almacenamiento) {
        this.tipo = tipo;
        this.num_Serie = num_Serie;
        this.precio = precio;
        this.grados = grados;
        Cores = cores;
        Almacenamiento = almacenamiento;
    }

    @Override
    public double dameGrados()
    {
        return grados;
    }
    @Override
    public double damePrecio()
    {
        return precio;
    }
    @Override
    public TipoComponente dameTipo()
    {
        return tipo;
    }

    @Override
    public String dameSerie()
    {
        return this.num_Serie;
    }

    @Override
    public String toString() {
        return "Componente{" +
                "tipo=" + tipo +
                ", num_Serie='" + num_Serie + '\'' +
                ", precio=" + precio +
                ", grados=" + grados +
                ", Cores=" + Cores +
                ", Almacenamiento=" + Almacenamiento +
                '}';
    }
}
