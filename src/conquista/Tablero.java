package conquista;

public class Tablero {

	private Casilla[][] casillas;

	public Tablero(int tamano) {
		super();
		casillas = new Casilla[tamano][tamano];
		generarTablero();
	}
	
	private void generarTablero(){
		
	}
	
	public char calcularVictoria(){
		return ' ';
	}
	
	public int[][] conversorCasilla(String casilla){
		return null;
	}
	
	public boolean validarMovimiento(String cOrigen, String cDestino){
		return false;
	}
}
