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
		bora bora
		return null;
	}
	
	/**
	 * Comprueba si la acci�n de movimiento es v�lida.
	 * 
	 * @param cOrigen Casilla origen de la acci�n
	 * @param cDestino Casilla destino de la acci�n (Puede ser nula para defensa)
	 * @param tipo Tipo de acci�n a ejecutar 'a' para ataque y 'd' para defensa
	 * @param idj ID del jugador
	 * @return true si la acci�n es v�lida y false si no lo es
	 */
	public boolean validarMovimiento(String cOrigen, String cDestino, char tipo, char idj){
		return false;
	}
}
