package conquista;

public class Dado {

	private int resultado;

	public Dado() {
		super();
		resultado = tirarDado();
	}
	
	private int tirarDado(){
		return (int) (Math.random()*10);
	}

	public int getResultado() {
		return resultado;
	}
	
}
