package conquista;

import java.util.ArrayList;

public class Tablero {

	private Casilla[][] casillas;

	public Tablero(int tamano) {
		super();
		casillas = new Casilla[tamano][tamano];
		generarTablero();
	}
	
	private void generarTablero(){
		int resistencia;
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				while ((resistencia = (int)(Math.random()*100)+1) < 20);
				this.getCasillas()[i][j] = new Casilla(' ',resistencia,(int)(Math.random()*3)+1);
			}
		}
		this.getCasillas()[0][0] = new Casilla ('V', 150, 3);
		this.getCasillas()[this.getCasillas().length-1][this.getCasillas()[0].length-1] = new Casilla ('R', 150, 3);
	}
	
	public char calcularVictoria(){
		char equipo = this.getCasillas()[0][0].getEquipo();
		for (int i = 0; i < this.getCasillas().length; i++){
			for (int j = 0; j < this.getCasillas()[i].length; j++){
				if (equipo != this.getCasillas()[i][j].getEquipo()) return ' ';
			}
		}
		return equipo;
	}
	
	public int[] conversorCasilla(String casilla){
		ArrayList letras = new ArrayList<Character>(), numeros = new ArrayList<Character>();
		boolean cambio = false;
		for (int i = 0;!cambio && i < casilla.length();i++){
			if (Character.isAlphabetic(casilla.charAt(i))){
				if (numeros.size() == 0) letras.add(casilla.charAt(i));
				else return null;
			} else if (Character.isDigit(casilla.charAt(i))) numeros.add(casilla.charAt(i));
		}
		if (letras.size() == 0 || numeros.size() == 0) return null;
		int x = 0, y = 0;
		for (int i = 1, j = numeros.size()-1; j >= 0; i*=10, j--){
			x += Integer.parseInt(Character.toString((char)numeros.get(j)))*i;
		}
		for (int i = 0; i < letras.size(); i++){
			y += Character.toUpperCase(((char)letras.get(i)))-65+((i==0)?0:1);
		}
		return new int []{x,y};
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
