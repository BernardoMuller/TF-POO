package src.entidades;

import src.entidades.EspacoPorto;
import src.entidades.Espaconave;

public abstract class Transporte {

	private int identificador;

	private EspacoPorto origem;

	private EspacoPorto destino;

	private Espaconave espaconave;

	private double custo;

	private Espaconave nave;

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

	public void setEspaconave(Espaconave espaconave) {
		this.espaconave = espaconave;
	}

	public int getIdentificador() {
		return identificador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public abstract double calculaDistancia();

	public abstract double calculaCusto();

	public static EspacoPorto getTerra() {
		return terra;
	}

	public EspacoPorto getOrigem() {
		return origem;
	}

	public EspacoPorto getDestino() {
		return destino;
	}

	public Espaconave getEspaconave() {
		return espaconave;
	}

	public double getCusto() {
		return custo;
	}

	public Espaconave getNave() {
		return nave;
	}

	public void setNave(Espaconave nave) {
		this.nave = nave;
	}

	@Override
	public String toString() {
		return "identificador=" + identificador +
				", origem=" + origem +
				", destino=" + destino +
				", espaconave=" + espaconave +
				", custo=" + custo +
				", nave=" + nave +
				", estado='" + estado;
	}

	public abstract String geraResumo();
}
