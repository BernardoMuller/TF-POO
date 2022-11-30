package src.subclasses;

import src.entidades.EspacoPorto;
import src.entidades.Espaconave;
import src.entidades.Transporte;

public class TransportePessoas extends Transporte {
    private int identificador;

    private EspacoPorto origem;

    private EspacoPorto destino;

    private int quantidadePessoas;

    private double custo;

    private double distancia;

    private String estado;

    private Espaconave nave;

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TransportePessoas(int identificador, EspacoPorto origem, EspacoPorto destino, int quantidadePessoas){
        super(identificador, origem, destino);
        this.quantidadePessoas = quantidadePessoas;
        estado = "Pendente";
        calculaDistancia();
        calculaCusto();
    }

    public TransportePessoas(int identificador, EspacoPorto destino, int quantidadePessoas){
        super(identificador, destino);
        origem = Transporte.getTerra();
        this.quantidadePessoas = quantidadePessoas;
        estado = "Pendente";
        calculaDistancia();
        calculaCusto();
    }

    @Override
    public double calculaDistancia() {
        double x= Math.pow((super.getOrigem().getCoordX() - super.getDestino().getCoordX()),2);
        double y= Math.pow((super.getOrigem().getCoordY() - super.getDestino().getCoordY()),2);
        double z= Math.pow((super.getOrigem().getCoordZ()-super.getDestino().getCoordZ()),2);
        distancia = Math.sqrt(x+y+z);
        return distancia;
    }

    @Override
    public int getIdentificador() {
        return super.getIdentificador();
    }

    @Override
    public String getEstado() {
        return estado;
    }

    @Override
    public double calculaCusto() {
        double pessoas = quantidadePessoas *100;
        double pDistanciaa = 0;
        if(distancia<0.5){
            pDistanciaa = 1000000 * distancia;
        }
        else{
            pDistanciaa = 100* distancia;
        }

        custo = pessoas * pDistanciaa;
        return custo;
    }

    public void setNave(Espaconave nave) {
        this.nave=nave;
    }

    @Override
    public Espaconave getNave() {
        return nave;
    }

    @Override
    public String toString() {
        return "Transporte de Pessoas:" +
                " identificador=" + super.getIdentificador() +
                ", origem=" + super.getOrigem() +
                ", destino=" + super.getDestino() +
                ", quantidadePessoas=" + quantidadePessoas +
                ", custo=" + custo +
                ", distancia=" + distancia +
                ", estado='" + estado +
                ", espaçonave='" + getNave();
    }

    @Override
    public String geraResumo() {
        return "2;"+identificador+";"+origem.getNumero()+";"+destino.getNumero()+";"+quantidadePessoas;
    }
}
