package conquista;

public class Accion {

	public boolean Ataque (String cOrigen, String cDestino, Jugador jugador, Tablero tablero){
		if (cOrigen == null || cDestino == null) return false;
		if (!tablero.validarMovimiento(cOrigen, cDestino, 'a', jugador.getId())) return false;
		int[] pOrigen, pDestino;
		pOrigen = tablero.conversorCasilla(cOrigen);
		pDestino = tablero.conversorCasilla(cDestino);
		int dados = tablero.getCasillas()[pOrigen[0]][pOrigen[1]].getRecursos();
		int resultado=0;
		for (int i = 0; i<dados; i++) resultado += new Dado().getResultado();
		jugador.setMovimiento(resultado*-1, pDestino);
		return true;
	}
	
	public void Defensa (String cOrigen, String cDestino, Jugador jugador, Tablero tablero){
		
	}
	
	public void Defensa (String cOrigen, Jugador jugador, Tablero tablero){
		
	}
	
	public boolean retirada (){
		return true;
	}
	
	public boolean terminarTurno(){
		return true;
	}
}
