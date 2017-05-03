package pgn.poo.utiles;

/**
 * Clase utilizada para la gesti�n de un men�. Se dedica a:
 * 
 * <li>Mostrar las opciones del men�
 * 
 * <li>Recoger y devolver las opciones de un men�
 * 
 * @author mlmc
 * 
 */
public class Menu {
	public final int SALIR;
	/**
	 * T�tulo del men�
	 */
	private String titulo;
	/**
	 * Opciones del men�
	 */
	private String opciones[];
	/**
	 * N�mero de opciones del men�
	 */
	private int numOpciones = 2;

	/**
	 * Crea un men� para comunicarse con el usuario a trav�s del teclado y de la
	 * consola.
	 * 
	 * @param titulo
	 *            t�tulo del men�
	 * @param opciones
	 *            opciones del men�
	 */
	public Menu(String titulo, String[] opciones) {
		setTitulo(titulo);
		setOpciones(opciones);
		setNumOpciones();
		SALIR = getNumOpciones();
	}

	private int getNumOpciones() {

		return numOpciones;
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	private void setOpciones(String[] opciones) {
		this.opciones = new String[opciones.length + 1];
		int i = 0;
		for (String string : opciones) {
			this.opciones[i++] = string;
		}
		this.opciones[i] = "Salir";
	}

	private void setNumOpciones() {
		this.numOpciones = opciones.length;
	}

	/**
	 * Gestiona el men�. Consiste en mostrar las opcines y recoger la opci�n
	 * seleccionada por el usuario
	 * 
	 * @return opci�n v�lida del men�
	 */
	public int gestionar() {
		mostrar();
		return recogerOpcion();
	}

	/**
	 * Muestra las opciones del men�
	 */
	private void mostrar() {
		int i = 1;
		System.out.println("\n**" + titulo);
		for (String elemento : opciones)
			System.out.println("(" + (i++) + ") " + elemento);
	}

	/**
	 * Recoge la opci�n v�lida del men�, comenzando por 1.
	 * 
	 * @return opci�n v�lida
	 */
	private int recogerOpcion() {
		int opcion;
		do {
			opcion = Teclado.leerEntero();
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}
}
