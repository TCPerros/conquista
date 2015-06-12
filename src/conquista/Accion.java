package conquista;

public class Accion {

	/**
	 * Calcula un movimiento de ataque
	 * 
	 * @param cOrigen Casilla origen del ataque perteneciente al jugador activo
	 * @param cDestino Casilla destino del ataque perteneciente a un jugador rival
	 * @param jugador Jugador que realiza la acción
	 * @param tablero Tablero del juego activo
	 * @return true si el ataque ha tenido éxito, falso en caso contrario
	 */
	public boolean Ataque (String cOrigen, String cDestino, Jugador jugador, Tablero tablero){
		if (cOrigen == null || cDestino == null) return false;
		if (!tablero.validarMovimiento(cOrigen, cDestino, 'a', jugador.getId())) return false;
		int[] pOrigen, pDestino;
		pOrigen = tablero.conversorCasilla(cOrigen);
		pDestino = tablero.conversorCasilla(cDestino);
		int dados = tablero.getCasillas()[pOrigen[0]][pOrigen[1]].getRecursos();
		int resultado=0;
		for (int i = 0; i<dados; i++) resultado += new Dado().getResultado();
		jugador.setMovimiento(jugador.getMovimientos()[pDestino[0]][pDestino[1]]+(resultado*-1), pDestino);
		return true;
	}
	
	public boolean Defensa (String cOrigen, String cDestino, Jugador jugador, Tablero tablero){
		if (cOrigen == null) return false;
		if (!tablero.validarMovimiento(cOrigen, cDestino, 'd', jugador.getId())) return false;
		int[] pOrigen, pDestino;
		cDestino = (cDestino == null)? cOrigen : cDestino;
		pOrigen = tablero.conversorCasilla(cOrigen);
		pDestino = tablero.conversorCasilla(cDestino);
		int dados = tablero.getCasillas()[pOrigen[0]][pOrigen[1]].getRecursos();
		int resultado=0;
		for (int i = 0; i<dados; i++) resultado += new Dado().getResultado();
		jugador.setMovimiento(jugador.getMovimientos()[pDestino[0]][pDestino[1]]+(resultado), pDestino);
		return true; 
	}
	
	public boolean retirada (){
		return true;
	}
	
	public boolean terminarTurno(){
		return true;
	}
}
