package org.Tienda;
import org.Tienda.Componente.Factoria.FactoriaComponentes;
import org.Tienda.Componente.Factoria.IComponenteFactory;
import org.Tienda.Componente.TipoComponente;
import org.Tienda.Ordenador.Ordenador;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        IComponenteFactory Factoria;
        Ordenador OrdenadorDeMaria;
        Factoria = new FactoriaComponentes();
        OrdenadorDeMaria = new Ordenador();
        OrdenadorDeMaria.add(Factoria.dameComponente(TipoComponente.Procesador,
                "789-XCS",134,10,9,0));
        OrdenadorDeMaria.add(Factoria.dameComponente(TipoComponente.Memoria,
                "879FH",100,10,0,512));
        OrdenadorDeMaria.add(Factoria.dameComponente(TipoComponente.Almacenamiento,
                "789-XX",50,10,0,500000));
        OrdenadorDeMaria.add(Factoria.dameComponente(TipoComponente.AlmacenamientoExterno,
                "1789-XCS",134,10,0,9000000));

        System.out.println(OrdenadorDeMaria);

    }
}