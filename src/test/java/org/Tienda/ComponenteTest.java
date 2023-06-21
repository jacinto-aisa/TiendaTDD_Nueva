package org.Tienda;

import org.Tienda.Componente.Factoria.FactoriaComponentes;
import org.Tienda.Componente.Factoria.IComponenteFactory;
import org.Tienda.Componente.IComponenteIdentificable;
import org.Tienda.Componente.TipoComponente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComponenteTest {


    @Test
    @DisplayName("Fabricacion Correcta de Componente")
    void FabricacionCorrectaDeComponentes()
    {
        IComponenteFactory miFactoria = new FactoriaComponentes();
        IComponenteIdentificable miComponente;
        miComponente = miFactoria.dameComponente(TipoComponente.Procesador,
                                          "ygygyy",9,10,5,0);
        Assertions.assertNotNull(miComponente,"El componente no ha sido creado satisfactoriamente");
        Assertions.assertEquals(9,miComponente.damePrecio(),0.01);
        Assertions.assertEquals(10,miComponente.dameGrados(),0.01);
        Assertions.assertEquals(TipoComponente.Procesador,miComponente.dameTipo());
        Assertions.assertEquals("ygygyy",miComponente.dameSerie());
        miComponente = miFactoria.dameComponente(TipoComponente.AlmacenamientoExterno,
                "1789-XCS",134,22,0,9000000);
        Assertions.assertNotNull(miComponente,"El componente no ha sido creado satisfactoriamente");
        Assertions.assertEquals(134,miComponente.damePrecio(),0.01);
        Assertions.assertEquals(22,miComponente.dameGrados(),0.01);
        Assertions.assertEquals(TipoComponente.AlmacenamientoExterno,miComponente.dameTipo());
        Assertions.assertEquals("1789-XCS",miComponente.dameSerie());

    }
    @Test
    @DisplayName("Fabricacion No Correcta de Componente")
    void FabricacionNoCorrectaDeComponentes() {
        IComponenteFactory miFactoria = new FactoriaComponentes();
        IComponenteIdentificable miComponente;
        miComponente = miFactoria.dameComponente(TipoComponente.Procesador,
                "ygygyy", -9, 10, 5, 0);
        Assertions.assertNull(miComponente, "El componente no ha sido creado satisfactoriamente");
        miComponente = miFactoria.dameComponente(TipoComponente.Procesador,
                "ygygyy", 9, -10, 5, 0);
        Assertions.assertNull(miComponente, "El componente no ha sido creado satisfactoriamente");
        miComponente = miFactoria.dameComponente(TipoComponente.Procesador,
                "", 9, 10, 5, 0);
        Assertions.assertNull(miComponente, "El componente no ha sido creado satisfactoriamente");
        miComponente = miFactoria.dameComponente(TipoComponente.Procesador,
                "", 9, 10, -5, 0);
        Assertions.assertNull(miComponente, "El componente no ha sido creado satisfactoriamente");
        miComponente = miFactoria.dameComponente(TipoComponente.Procesador,
                "", 9, 10, -5, -1);
        Assertions.assertNull(miComponente, "El componente no ha sido creado satisfactoriamente");

    }

}