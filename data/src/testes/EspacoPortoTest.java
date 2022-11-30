package src.testes;

import src.entidades.EspacoPorto;

import static org.junit.jupiter.api.Assertions.*;

class EspacoPortoTest {

    private EspacoPorto porto = new EspacoPorto(1, "Terra", 0, 1, 2);

    @org.junit.jupiter.api.Test
    void getNumero() {
        assertEquals(1, porto.getNumero());
    }

    @org.junit.jupiter.api.Test
    void getNome() {
        assertEquals("Terra", porto.getNome());
    }

    @org.junit.jupiter.api.Test
    void getCoordX() {
        assertEquals(0, porto.getCoordX());
    }

    @org.junit.jupiter.api.Test
    void getCoordY() {
        assertEquals(1, porto.getCoordY());
    }

    @org.junit.jupiter.api.Test
    void getCoordZ() {
        assertEquals(2, porto.getCoordZ());
    }
}