package src.testes;

import src.entidades.EspacoPorto;
import src.entidades.Transporte;
import src.subclasses.FTL;
import src.subclasses.TransporteMaterial;

import static org.junit.jupiter.api.Assertions.*;

class TransporteTest {

    private EspacoPorto porto = new EspacoPorto(1, "Terra", 0, 1, 1);
    private EspacoPorto porto2 = new EspacoPorto(2, "Lua", 0, 1, 1);

    private FTL ftl = new FTL("Nave FTL", porto, 200, 150 );
    private Transporte tr = new TransporteMaterial(1, porto, porto2,2, "Ferro" );

    @org.junit.jupiter.api.Test
    void setEspaconave() {
        tr.setEspaconave(ftl);
        assertEquals(ftl, tr.getEspaconave());
    }

    @org.junit.jupiter.api.Test
    void getIdentificador() {
        assertEquals(1, tr.getIdentificador());
    }

    @org.junit.jupiter.api.Test
    void getEstado() {
        assertEquals("Pendente", tr.getEstado());
    }

    @org.junit.jupiter.api.Test
    void setEstado() {
        tr.setEstado("Finalizado");
        assertEquals("Finalizado", tr.getEstado());
    }

    @org.junit.jupiter.api.Test
    void calculaDistancia() {
        assertEquals(0, tr.calculaDistancia());
    }

    @org.junit.jupiter.api.Test
    void calculaCusto() {
        assertEquals(0, tr.calculaDistancia());
    }

}