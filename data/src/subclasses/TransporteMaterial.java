package src.subclasses;

import src.entidades.EspacoPorto;
import src.entidades.Transporte;

public class TransporteMaterial extends Transporte {
    private int identificador;

    private EspacoPorto origem;

    private EspacoPorto destino;

    private int quantidadePessoas;

    private double custo;

    private double distancia;

    private double carga;

    private String descricaoMaterial;

    private String estado;

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TransporteMaterial(int identificador, EspacoPorto origem, EspacoPorto destino, int carga, String descricaoMaterial){
        super(identificador, origem, destino);
        estado = "Pendente";
        this.carga=carga;
        this.descricaoMaterial = descricaoMaterial;
        calculaDistancia();
        calculaCusto();
    }

    public TransporteMaterial(int identificador, EspacoPorto destino, int carga, String descricaoMaterial){
        super(identificador, destino);
        origem = Transporte.getTerra();
        estado = "Pendente";
        this.carga=carga;
        this.descricaoMaterial = descricaoMaterial;
        calculaDistancia();
        calculaCusto();
    }


    @Override
    public int getIdentificador() {
        return identificador;
    }

    @Override
    public String getEstado() {
        return estado;
    }

    @Override
    public double calculaDistancia() {
        double x= Math.pow((destino.getCoordX() - origem.getCoordX()),2);
        double y= Math.pow((destino.getCoordY() - origem.getCoordY()),2);
        double z= Math.pow((destino.getCoordZ()-origem.getCoordZ()),2);
        distancia = Math.sqrt(x+y+z);
        return distancia;
    }

    @Override
    public double calculaCusto() {
        double cargasP = carga *500;
        double pDistanciaa = 0;
        if(distancia<0.5){
            pDistanciaa = 1000000 * distancia;
        }
        else{
            pDistanciaa = 100* distancia;
        }

        custo = cargasP * pDistanciaa;
        return custo;
    }
}
