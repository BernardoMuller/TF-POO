package src.testes;

import src.entidades.EspacoPorto;
import src.subclasses.FTL;
import src.subclasses.Subluz;

import static org.junit.jupiter.api.Assertions.*;

class SubluzTest {

    private EspacoPorto porto = new EspacoPorto(1, "Terra", 0, 1, 2);
    private Subluz sub = new Subluz("Nave Sub", porto, 0.3, "Nuclear" );

    @org.junit.jupiter.api.Test
    void getTipo() {
        assertEquals(1, sub.getTipo());
    }

    @org.junit.jupiter.api.Test
    void getLocalAtual() {
        assertEquals(porto, sub.getLocalAtual());
    }

    @org.junit.jupiter.api.Test
    void setLocalAtual() {
        EspacoPorto porto2 = new EspacoPorto(2, "Lua", 0, 2, 1);
        sub.setLocalAtual(porto2);
        assertEquals(porto2, sub.getLocalAtual());
    }

    @org.junit.jupiter.api.Test
    void getCombustivel() {
        assertEquals("Nuclear", sub.getCombustivel());
    }

    @org.junit.jupiter.api.Test
    void setCombustivel() {
        sub.setCombustivel("Ion");
        assertEquals("Ion", sub.getCombustivel());
    }

    @org.junit.jupiter.api.Test
    void getVelocidade() {
        assertEquals(0.3, sub.getVelocidade());
    }

    @org.junit.jupiter.api.Test
    void setVelocidade() {
        sub.setVelocidade(0.2);
        assertEquals(0.2, sub.getVelocidade());
    }
}