package conquista;

public class Conquista {

	public static void main(String[] args) {
		Tablero t = new Tablero(10);
		t.dibujarTablero();
		int [] pos = t.conversorCasilla("K10");
		System.out.println((pos != null)?pos[0]+" "+pos[1]:"null");
	}

}
