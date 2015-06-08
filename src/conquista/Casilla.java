package conquista;

public class Casilla {
	
	private char equipo;
	private int resistencia;
	private int recursos;
	private boolean uso;
	private int valorTirada; //Quizá no se use
	
	public Casilla(char equipo, int resistencia, int recursos) {
		super();
		this.equipo = equipo;
		this.resistencia = resistencia;
		this.recursos = recursos;
		this.uso = false;
	}

	public char getEquipo() {
		return equipo;
	}

	public void setEquipo(char equipo) {
		this.equipo = equipo;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public boolean isUso() {
		return uso;
	}

	public void setUso(boolean uso) {
		this.uso = uso;
	}

	public int getRecursos() {
		return recursos;
	}
	
}
