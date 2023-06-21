package org.Tienda.Componente;

import org.Tienda.Componente.Caracteristicas.ICoreable;
import org.Tienda.Componente.Caracteristicas.IMegable;

public class Componente implements IComponenteIdentificable {
    private TipoComponente tipo;
    private String num_Serie;
    private double precio;
    private double grados;
    public ICoreable Cores;
    public IMegable Almacenamiento;

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
