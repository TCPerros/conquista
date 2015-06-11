package conquista;

public class Conquista {

	public static void main(String[] args) {
		Tablero t = new Tablero(10);
		t.dibujarTablero();
		int [] pos = t.conversorCasilla("ZzA10");
		System.out.println(pos[0]+" "+pos[1]);
	}

}
