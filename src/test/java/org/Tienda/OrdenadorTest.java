package org.Tienda;

import org.Tienda.Componente.Factoria.FactoriaComponentes;
import org.Tienda.Componente.Factoria.IComponenteFactory;
import org.Tienda.Componente.TipoComponente;
import org.Tienda.Componente.Validadores.ValidadorDeOrdenador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.Tienda.Ordenador.Ordenador;

import java.util.function.Predicate;

public class OrdenadorTest {
    static IComponenteFactory  Factoria;
    static Ordenador OrdenadorDeMaria;
    static Ordenador OrdenadorDePruebas;
    @BeforeAll
    static void Iniciar()
    {
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
        OrdenadorDePruebas = new Ordenador();
        OrdenadorDePruebas.getPiezas().put("ssss",
                Factoria.dameComponente(TipoComponente.Procesador,
                        "789-XCS",134,10,9,0));
        OrdenadorDePruebas.getPiezas().put("ssss",
                Factoria.dameComponente(TipoComponente.Procesador,
                        "789-XCS",134,10,9,0));

        OrdenadorDePruebas.getPiezas().put("ssss",
                Factoria.dameComponente(TipoComponente.Memoria,
                        "789-XCS",134,10,9,0));


    }


    @Test
    @DisplayName("Fabricacion Correcta de Ordenador")
    void FabricacionCorrectaDeOrdenador()
    {
        Assertions.assertEquals(418,OrdenadorDeMaria.damePrecio(),0.0001);
        Assertions.assertEquals(40,OrdenadorDeMaria.dameGrados(),0.0001);
    }

    @Test
    @DisplayName("Impedir meter varios de un tipo")
    void IntroduccionMultipleOk()
    {
        boolean resultdo = OrdenadorDeMaria.add(Factoria.dameComponente(TipoComponente.Procesador,
            "789-XCS",134,10,9,0));
        Assertions.assertFalse(resultdo);
    }
    @Test
    @DisplayName("Comprobar composicion")
    void ComprobacionElementosOk()
    {
        Predicate<Ordenador> Val = new ValidadorDeOrdenador();
        Assertions.assertFalse(Val.test(OrdenadorDePruebas));
        Assertions.assertTrue(Val.test(OrdenadorDeMaria));
    }

}
