package conquista;

public class Controlador {

	public Controlador(){
		super();
	}
	
	public void principal(){
		
	}
	
	private boolean menuInicial(){
		
		return true;
	}
	
	private byte menuAccion() {
		return 0;
	}
	
	private boolean resolucion(Jugador j1, Jugador j2, Tablero t){
		Casilla[][] nuevoTablero = t.getCasillas();
		int resCasilla, movj1, movj2;
		char eCasilla;
		int[][] resolucion = new int[nuevoTablero.length][nuevoTablero[0].length];
		for (int i = 0; i < resolucion.length; i++){
			for (int j = 0; j < resolucion[0].length; j++){
				resCasilla = nuevoTablero[i][j].getResistencia();
				eCasilla = nuevoTablero[i][j].getEquipo();
				movj1 = j1.getMovimientos()[i][j];
				movj2 = j2.getMovimientos()[i][j];
				if (movj1 < 0){
					if (movj2 < 0){
						resCasilla = (resCasilla+movj1+movj2 < 0)? 0 : resCasilla+movj1+movj2;
						if (resCasilla == 0) {
							if (movj1>movj2) eCasilla = j2.getId();
							else if (movj2>movj1) eCasilla = j1.getId();
						}
					}
				}
				//resolucion[i][j] = j1.getMovimientos()[i][j] + j2.getMovimientos()[i][j];
			}
		}
		return false;
	}
}
