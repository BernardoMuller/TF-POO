package src.testes;

import src.entidades.Espaconave;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class EspaconaveTest {

    @org.junit.jupiter.api.Test
    void getNome() {
        Espaconave espaconave = new Espaconave("Millenium Falcon");
        String nome = "Millenium Falcon";
        assertEquals(nome, espaconave.getNome());
    }

}