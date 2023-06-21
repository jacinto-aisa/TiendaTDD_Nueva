package org.Tienda.Pedido;

import java.util.ArrayList;

import org.Tienda.Componente.ICosteYGrados;
import org.Tienda.Ordenador.Ordenador;
public class Pedido implements ICosteYGrados {
    ArrayList<Ordenador> ordenadores;

    public Pedido() {
        ordenadores = new ArrayList<>();
    }

    public void add(Ordenador Ordenata)
    {
        ordenadores.add(Ordenata);
    }

    @Override
    public double dameGrados() {
        return ordenadores.stream().mapToDouble(Ordenador::dameGrados).sum();

    }
    @Override
    public double damePrecio() {
        return ordenadores.stream().mapToDouble(Ordenador::damePrecio).sum();
    }
}
