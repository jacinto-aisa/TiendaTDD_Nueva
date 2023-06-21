package org.Tienda.Componente.Caracteristicas;

public class ConCores implements ICoreable {
    private final double cores;

    public ConCores(double cores) {
        this.cores = cores;
    }

    @Override
    public double dameCores() {
        return cores;
    }
}
