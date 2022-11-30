package src.testes;

import src.entidades.EspacoPorto;
import src.entidades.Espaconave;
import src.subclasses.FTL;

import static org.junit.jupiter.api.Assertions.*;

class FTLTest {

    private EspacoPorto porto = new EspacoPorto(1, "Terra", 0, 1, 2);
    private FTL ftl = new FTL("Nave FTL", porto, 200, 150 );

    @org.junit.jupiter.api.Test
    void getTipo() {
        assertEquals(2, ftl.getTipo());
    }

    @org.junit.jupiter.api.Test
    void getLocalAtual() {
        assertEquals(porto, ftl.getLocalAtual());
    }

    @org.junit.jupiter.api.Test
    void setLocalAtual() {
        EspacoPorto porto2 = new EspacoPorto(2, "Lua", 0, 2, 1);
        ftl.setLocalAtual(porto2);
        assertEquals(porto2, ftl.getLocalAtual());
    }

    @org.junit.jupiter.api.Test
    void getVelocidadeMax() {
        assertEquals(200, ftl.getVelocidadeMax());
    }

    @org.junit.jupiter.api.Test
    void setVelocidadeMax() {
        ftl.setVelocidadeMax(350);
        assertEquals(350, ftl.getVelocidadeMax());
    }

    @org.junit.jupiter.api.Test
    void getCargaMax() {
        assertEquals(150, ftl.getCargaMax());
    }

    @org.junit.jupiter.api.Test
    void setCargaMax() {
        ftl.setCargaMax(100);
        assertEquals(100, ftl.getCargaMax());
    }
}