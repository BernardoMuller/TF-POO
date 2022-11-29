package src;

public abstract class Transporte {

	private int identificador;

	private EspacoPorto origem;

	private EspacoPorto destino;

	private double custo;

	private String estado;

	private static EspacoPorto terra = new EspacoPorto(1, "Terra", 0,0,0);

	public Transporte(int identificador, EspacoPorto origem, EspacoPorto destino) {
		this.identificador = identificador;
		this.origem = origem;
		this.destino = destino;
		estado = "Pendente";
	}

	public Transporte(int identificador, EspacoPorto destino){
		this.identificador = identificador;
		this.origem = terra;
		this.destino = destino;
		estado = "Pendente";
	}



	public abstract double calculaDistancia();

	public abstract double calculaCusto();

	public static EspacoPorto getTerra() {
		return terra;
	}
}
