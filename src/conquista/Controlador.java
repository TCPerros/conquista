package conquista;

import java.util.Scanner;

public class Controlador {

	public Controlador(){
		super();
	}
	
	public void principal(){
		if(menuInicial()){
			System.out.println("Todo bien todo correcto");
		}
		else{
			System.out.println("Y yo que me alegro");
		}
	}
	
	private boolean menuInicial(){
		boolean teclaCorrecta = false;
		String eleccion;
		System.out.println("BIENVENIDO A CONQUISTA V0.01 \n\n");

		while(!teclaCorrecta){
			
        Scanner leer = new Scanner(System.in);
		System.out.println("Elija una de las siguientes opciones \n");
		System.out.println("Jugar: J");
		System.out.println("Salir: S");
		eleccion=leer.next();
		
			if(eleccion.equalsIgnoreCase("J")){
				return true;
				
			}
			if(eleccion.equalsIgnoreCase("S")){
				return false;
			}
			
			System.out.println("Has pulsado una tecla incorrecta, intente de nuevo");
		}
		return false;
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
