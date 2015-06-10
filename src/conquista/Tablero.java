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
	
	public int[] conversorCasilla(String casilla){
		
		
		return null;
	}
	
	/**
	 * Comprueba si la acción de movimiento es válida.
	 * 
	 * @param cOrigen Casilla origen de la acción
	 * @param cDestino Casilla destino de la acción (Puede ser nula para defensa)
	 * @param tipo Tipo de acción a ejecutar 'a' para ataque y 'd' para defensa
	 * @param idj ID del jugador
	 * @return true si la acción es válida y false si no lo es
	 */
	public boolean validarMovimiento(String cOrigen, String cDestino, char tipo, char idj){
		if (cOrigen == null) return false;
		if (tipo != 'a' && tipo != 'd') return false;
		if (tipo == 'a' && cDestino == null) return false;
		int[] pOrigen, pDestino;
		pOrigen = this.conversorCasilla(cOrigen);
		pDestino = this.conversorCasilla(cDestino);
		if (this.getCasillas()[pOrigen[0]][pOrigen[1]].getEquipo() != idj) return false;
		if (tipo == 'a' && this.getCasillas()[pDestino[0]][pDestino[1]].getEquipo() == idj) return false;
		if (tipo == 'd' && cDestino != null && this.getCasillas()[pDestino[0]][pDestino[1]].getEquipo() != idj) return false;
		if (cDestino != null){
			int restax = pDestino[0]-pOrigen[0], restay = pDestino[1]-pOrigen[1];
			if (Math.abs(restax)>1 || Math.abs(restay)>1) return false;
		}
		return true;
	}
	
	public Casilla[][] getCasillas(){
		return casillas;
	}
}
