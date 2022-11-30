package src.subclasses;

import src.entidades.EspacoPorto;
import src.entidades.Espaconave;

public class FTL extends Espaconave {

    private int tipo;

    private EspacoPorto localAtual;

    private double velocidadeMax;

    private int cargaMax;

    public FTL(String nome, EspacoPorto ep, double velocidadeMax, int cargaMax) {
        super(nome);
        this.tipo = 2;
        this.localAtual = ep;
        this.velocidadeMax = velocidadeMax;
        this.cargaMax = cargaMax;
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

    public double getVelocidadeMax() {
        return velocidadeMax;
    }

    public void setVelocidadeMax(double velocidadeMax) {
        this.velocidadeMax = velocidadeMax;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public String geraResumo(){
        return "2"+";"+getNome()+";"+getLocalAtual().getNumero()+";"+getVelocidadeMax()+";"+getCargaMax();
    }

    @Override
    public String toString() {
        return "FTL{" +
                "tipo=" + tipo +
                ", localAtual=" + localAtual +
                ", velocidadeMax=" + velocidadeMax +
                ", cargaMax=" + cargaMax +
                '}';
    }
}
