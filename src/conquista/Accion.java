package conquista;

public class Accion {

	public void Ataque (String cOrigen, String cDestino){
		int[][] origen, destino;
		origen = Tablero.conversorCasilla(cOrigen);
	}
	
	public void Defensa (String cOrigen, String cDestino){
		
	}
	
	public void Defensa (String cOrigen){
		
	}
	
	public boolean retirada (){
		return true;
	}
	
	public boolean terminarTurno(){
		return true;
	}
}
