package src.entidades;

public class EspacoPorto {

	private int numero;

	private String nome;

	private double coordX;

	private double coordY;

	private double coordZ;

	public EspacoPorto(int numero, String nome, double coordX, double coordY, double coordZ) {
		this.numero = numero;
		this.nome = nome;
		this.coordX= coordX;
		this.coordY = coordY;
		this.coordZ = coordZ;
	}

	public int getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public double getCoordX() {
		return coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public double getCoordZ() {
		return coordZ;
	}

	@Override
	public String toString() {
		return "EspacoPorto: " +
				"numero=" + numero +
				", nome='" + nome + '\'' +
				", coordX=" + coordX +
				", coordY=" + coordY +
				", coordZ=" + coordZ;
	}

	public String geraResumo() {
		return numero+";"+nome+";"+coordX+";"+coordY+";"+coordZ;
	}
}
