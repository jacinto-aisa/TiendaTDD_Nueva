package org.Tienda;

import org.Tienda.Componente.Factoria.FactoriaComponentes;
import org.Tienda.Componente.Factoria.IComponenteFactory;
import org.Tienda.Componente.TipoComponente;
import org.Tienda.Ordenador.Ordenador;
import org.Tienda.Pedido.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    static IComponenteFactory Factoria;
    static Ordenador OrdenadorDeMaria;
    static Ordenador OrdenadorDePruebas;
    static Pedido PedidoPrueba;

    @BeforeAll
    static void Iniciar() {
        Factoria = new FactoriaComponentes();
        OrdenadorDeMaria = new Ordenador();
        OrdenadorDeMaria.add(Factoria.dameComponente(TipoComponente.Procesador,
                "789-XCS", 134, 10, 9, 0));
        OrdenadorDeMaria.add(Factoria.dameComponente(TipoComponente.Memoria,
                "879FH", 100, 10, 0, 512));
        OrdenadorDeMaria.add(Factoria.dameComponente(TipoComponente.Almacenamiento,
                "789-XX", 50, 10, 0, 500000));
        OrdenadorDeMaria.add(Factoria.dameComponente(TipoComponente.AlmacenamientoExterno,
                "1789-XCS", 134, 10, 0, 9000000));
        OrdenadorDePruebas = new Ordenador();
        OrdenadorDePruebas.getPiezas().put("ssssx",
                Factoria.dameComponente(TipoComponente.Procesador,
                        "789-XCS", 134, 10, 9, 0));
        OrdenadorDePruebas.getPiezas().put("ssssy",
                Factoria.dameComponente(TipoComponente.Almacenamiento,
                        "789-XCSX", 134, 10, 9, 0));
        OrdenadorDePruebas.getPiezas().put("ssss<",
                Factoria.dameComponente(TipoComponente.Memoria,
                        "789-XCSY", 134, 10, 9, 0));
        PedidoPrueba = new Pedido();
        PedidoPrueba.add(OrdenadorDeMaria);
        PedidoPrueba.add(OrdenadorDePruebas);
    }

    @Test
    @DisplayName("Fabricacion Correcta de Pedidos")
    void FabricacionCorrectaDePedidos()
    {
        Assertions.assertEquals(820,PedidoPrueba.damePrecio());
        Assertions.assertEquals(70,PedidoPrueba.dameGrados());
    }

}
