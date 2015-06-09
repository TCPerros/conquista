package conquista;

public class Accion {

	public boolean Ataque (String cOrigen, String cDestino, Jugador jugador, Tablero tablero){
		if (cOrigen == null || cDestino == null) return false;
		if (!tablero.validarMovimiento(cOrigen, cDestino, 'a', jugador.getId())) return false;
		
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
