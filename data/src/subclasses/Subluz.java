package src.subclasses;

import src.entidades.EspacoPorto;
import src.entidades.Espaconave;

public class Subluz extends Espaconave {

    private int tipo;

    private EspacoPorto localAtual;

    private double velocidade;

    private String combustivel;


    public Subluz(String nome, EspacoPorto localAtual, double velocidade, String combustivel) {
        super(nome);
        this.tipo = 1;
        this.localAtual = localAtual;
        this.velocidade = velocidade;
        this.combustivel = combustivel;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public EspacoPorto getLocalAtual() {
        return localAtual;
    }

    public void setLocalAtual(EspacoPorto localAtual) {
        this.localAtual = localAtual;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
}
