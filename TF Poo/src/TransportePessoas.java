package src;

public class TransportePessoas extends Transporte {
    private int identificador;

    private EspacoPorto origem;

    private EspacoPorto destino;

    private int quantidadePessoas;

    private double custo;

    private double distancia;

    private String estado;

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
        double x= Math.pow((destino.getCoordX() - origem.getCoordX()),2);
        double y= Math.pow((destino.getCoordY() - origem.getCoordY()),2);
        double z= Math.pow((destino.getCoordZ()-origem.getCoordZ()),2);
        distancia = Math.sqrt(x+y+z);
        return distancia;
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
}
