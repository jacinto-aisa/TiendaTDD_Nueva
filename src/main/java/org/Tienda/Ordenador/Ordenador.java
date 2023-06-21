package org.Tienda.Ordenador;

import org.Tienda.Componente.IComponenteIdentificable;
import org.Tienda.Componente.ICosteYGrados;
import org.Tienda.Componente.TipoComponente;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ordenador implements ICosteYGrados {
    private HashMap<String, IComponenteIdentificable> piezas;
    boolean procesadorExiste;
    boolean memoriaExiste;
    boolean almacenamientoExiste;

    private long dameCantidadPorTipo(TipoComponente tipo)
    {
        return piezas.values().stream().filter(p->p.dameTipo()==tipo).count();
    }
    public boolean add (IComponenteIdentificable elemento)
    {
        TipoComponente tipo = elemento.dameTipo();
        if (tipo.equals(TipoComponente.Procesador) ||
                tipo.equals(TipoComponente.Memoria) ||
                tipo.equals(TipoComponente.Almacenamiento))
        {
            if (dameCantidadPorTipo(tipo) == 1)
                return false;
            else {
                piezas.put(elemento.dameSerie(), elemento);
                return true;
            }
        }
        else
        {
            if (tipo.equals(TipoComponente.AlmacenamientoExterno))
            {
                piezas.put(elemento.dameSerie(),elemento);
                return true;
            }
        }
        return false;
    }
    public Ordenador()
    {
        memoriaExiste = false;
        procesadorExiste = false;
        almacenamientoExiste = false;
        piezas = new HashMap<>();
    }
    @Override
    public double dameGrados() {
        return piezas.values().stream().parallel().
                mapToDouble(ICosteYGrados::dameGrados).sum();
    }

    @Override
    public double damePrecio() {
        return piezas.values().stream().parallel().
                mapToDouble(ICosteYGrados::damePrecio).sum();
    }

    public HashMap<String, IComponenteIdentificable> getPiezas() {
        return piezas;
    }

    @Override
    public String toString() {
        String cadena = "Ordenador: \n";
        String cadenaComponentes = "";
        for(IComponenteIdentificable elemento : piezas.values())
        {
            cadenaComponentes+=elemento.toString()+"\n";
        }
        return cadena + cadenaComponentes;
    }
}
