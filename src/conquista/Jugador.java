package conquista;

public class Jugador {

	private char id;
	private boolean humano;
	private int[][] movimientos;
	
	public Jugador(char id, boolean humano) {
		super();
		this.id = id;
		this.humano = humano;
	}
	
	public void borrarMovimientos(int tamano){
		movimientos = new int[tamano][tamano];
	}

	public char getId() {
		return id;
	}

	public int[][] getMovimientos() {
		return movimientos;
	}
	
	public void setMovimiento (int valor, int[] posicion){
		
	}
	
}
