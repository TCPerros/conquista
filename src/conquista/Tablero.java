package conquista;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		Pattern pat = Pattern.compile("[a-zA-Z]+[1-9][0-9]*");
	    Matcher mat = pat.matcher(casilla);
	     if(mat.matches()) {
	    	String casillaMayus = casilla.toUpperCase();
	    	int tamanoTablero = casillas.length;
	    	char cadenaCasilla[] = casillaMayus.toCharArray();
	    	String parteNumerica = new String();
	    	String parteAlfabetica =  new String();
	    	int contadorAlfabetica = 0;
	    	
	    	for (int i = 0; i < cadenaCasilla.length; i++) {
	
	    		if (Character.isDigit(cadenaCasilla[i])){
					parteNumerica =  parteNumerica+String.valueOf(cadenaCasilla[i]);
				}
	    		else{
	    			parteAlfabetica = parteAlfabetica+String.valueOf(cadenaCasilla[i]);
	    			contadorAlfabetica++;
	    		}
			}
	    	//validar si el dato introducido esta en el tablero
	    	if(Integer.parseInt(parteNumerica)>tamanoTablero){
	    		return null;
	    	}
	    	
	    	int posicion[] = new int[2];
	    	posicion[0] = (contadorAlfabetica-1)+(parteAlfabetica.charAt(contadorAlfabetica-1)-64)-1;
	    	posicion[1] = Integer.parseInt(parteNumerica)-1;
	    	
	    	return posicion;
	     }else {
	    	return null;
	     }
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
	
	public void dibujarTablero(){
		/*for (int i=9552; i<=9580;i++) System.out.println(i+": "+(char)i);
		System.out.println((char)9484+' '+(char)9488+' '+(char)9492+' '+(char)9496+' '+(char)9500+' '+(char)9508+' '+
				(char)9516+' '+(char)9524+' '+(char)9532);
		System.out.println("╔═══════╦═══════╗");
		System.out.println("║100    ║50*    ║");
		System.out.println("║   V   ║       ║");
		System.out.println("║      3║      1║");
		System.out.println("╠═══════╬═══════╣");
		System.out.println("║23     ║100    ║");
		System.out.println("║       ║   A   ║");
		System.out.println("║      2║      3║");
		System.out.println("╚═══════╩═══════╝");*/
		int longx=casillas.length, longy=casillas[0].length;
		String linea="  ";
		
		//Pinta la línea de números
		for (int j=0;j<longx;j++) {
			linea += "    ";
			linea += j+1;
			linea += "   ";
		}
		System.out.println(linea);
		
		for(int i=0;i<longy;i++){
			
			//Pinta la parte de arriba del marco
			linea = "  ";
			if (i == 0) linea += "╔";
			//else 
			else linea += "╠";
			for (int j=0;j<longx;j++) {
				linea += "═══════";
				if (j == longx-1){
					if (i == 0 ) linea += "╗";
					else linea += "╣";
				}
				else if (i == 0) linea += "╦";
				else linea += "╬";
			}
			System.out.println(linea);
			linea="  ";
			
			//Pinta la línea de resistencia
			for (int j=0;j<longx;j++){
				linea += "║";
				linea += casillas[j][i].getResistencia();
				if (casillas[j][i].getResistencia() == casillas[j][i].getMaximo()) linea += "*";
				for (int k = (linea.length()-2)%8; k < 8 ; k++) linea += " ";
			}
			linea += "║";
			System.out.println(linea);
			linea="";
			
			//Pinta la línea de equipo
			linea += (char)(65+i);
			linea += " ";
			for (int j=0;j<longx;j++){
				linea += "║   ";
				linea += casillas[j][i].getEquipo();
				linea += "   ";
			}
			linea += "║";
			System.out.println(linea);
			linea="  ";
			
			//Pinta la línea de recursos
			for (int j=0;j<longx;j++){
				linea += "║      ";
				linea += casillas[j][i].getRecursos();
			}
			linea += "║";
			System.out.println(linea);
			linea = "  ";
			
			//Pinta la línea inferior del marco
			if (i == longy-1){
				linea += "╚";
				for (int j=0;j<longx;j++) {
					linea += "═══════";
					if (j != longx-1) linea += "╩";
				}
				linea += "╝";
				System.out.println(linea);
			}
		}
	}
}
