package org.Tienda.Componente.Caracteristicas;

public class ConMegas implements IMegable {
    private double almacenamiento;

    public ConMegas(double almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    @Override
    public double dameAlmacenamiento() {
        return almacenamiento;
    }
}
