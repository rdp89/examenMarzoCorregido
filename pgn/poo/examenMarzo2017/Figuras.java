package pgn.poo.examenMarzo2017;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.ListIterator;

import pgn.poo.examenMarzo2017.excepciones.DimensionNoValidaException;
import pgn.poo.examenMarzo2017.excepciones.FiguraNoExisteException;
import pgn.poo.examenMarzo2017.excepciones.ListaVaciaException;
import pgn.poo.examenMarzo2017.jerarquiaDeFiguras.Circulo;
import pgn.poo.examenMarzo2017.jerarquiaDeFiguras.Cuadrado;
import pgn.poo.examenMarzo2017.jerarquiaDeFiguras.FiguraCerrada;
import pgn.poo.examenMarzo2017.jerarquiaDeFiguras.Rectangulo;
import pgn.poo.examenMarzo2017.jerarquiaDeFiguras.Triangulo;
import pgn.poo.examenMarzo2017.matematicas.Aleatorio;
import pgn.poo.utiles.Teclado;

/**
 * Envoltorio de arraylist de FiguraCerrada
 * 
 * @author Rafael Delgado Peña
 *
 */
public class Figuras {
	private ArrayList<FiguraCerrada> figuritas = new ArrayList<FiguraCerrada>();
	Aleatorio aleatorio = new Aleatorio();

	void add(FiguraCerrada figura) {
		figuritas.add(figura);
	}

	/**
	 * Método encargado de mostrar todas las figuras que hay en el arraylist
	 * 
	 * @return la cadena con todas las figuras
	 * @throws ListaVaciaException
	 */
	StringBuilder mostrarFiguritas() throws ListaVaciaException {
		if (figuritas.isEmpty())
			throw new ListaVaciaException("La lista figuritas está vacía!");

		StringBuilder cadenaFiguritas = new StringBuilder();

		int n = 1;

		for (FiguraCerrada figuraCerrada : figuritas) {
			cadenaFiguritas.append("\n" + n++ + "º " + figuraCerrada);
		}
		return cadenaFiguritas;

	}

	/**
	 * Método encargado de mostrar solo los triángulos que hay en el arraylist
	 * 
	 * @return la cadena con los triángulos
	 * @throws ListaVaciaException
	 */
	StringBuilder mostrarTriangulos() throws ListaVaciaException {
		if (figuritas.isEmpty())
			throw new ListaVaciaException("La lista está vacía!");

		StringBuilder cadenaTriangulos = new StringBuilder();

		int n = 1;

		for (FiguraCerrada figuraCerrada : figuritas) {
			if (figuraCerrada instanceof Triangulo)
				cadenaTriangulos.append("\n" + n++ + "º " + figuraCerrada);
		}
		return cadenaTriangulos;
	}

	/**
	 * Método encargado de mostrar el arraylist del revés
	 * 
	 * @return la cadena con el arraylist del revés
	 * @throws ListaVaciaException
	 */
	StringBuilder mostrarDelReves() throws ListaVaciaException {
		if (figuritas.isEmpty())
			throw new ListaVaciaException("La lista está vacía!");

		StringBuilder cadenaDelReves = new StringBuilder();

		int n = 1;

		ListIterator<FiguraCerrada> it = figuritas.listIterator(figuritas.size());

		while (it.hasPrevious()) {
			cadenaDelReves.append("\n" + n++ + "º " + it.previous());
		}

		return cadenaDelReves;
	}

	/**
	 * Método encargado de comprobar si el array list está vacío
	 * 
	 * @return true o false
	 */
	boolean isEmpty() {
		return figuritas.isEmpty();
	}

	/**
	 * Método encargado de ejecutar las altas masivas
	 */

	void altasMasivas() {
		for (int i = 0; i < 3; i++) {
			anadirCircunferencia();
			anadirCuadrado();
			anadirRectangulo();
			anadirTriangulo();
		}
	}

	/**
	 * Método que crea un triángulo
	 */

	private void anadirTriangulo() {
		try {
			figuritas.add(new Triangulo(aleatorio.getAleatorio(), aleatorio.getAleatorio()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Método que crea un rectángulo
	 */
	private void anadirRectangulo() {
		try {
			figuritas.add(new Rectangulo(aleatorio.getAleatorio(), aleatorio.getAleatorio()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Método que crea un cuadrado
	 */
	private void anadirCuadrado() {
		try {
			figuritas.add(new Cuadrado(aleatorio.getAleatorio()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Método que crea una circunferencia
	 */
	private void anadirCircunferencia() {
		try {
			figuritas.add(new Circulo());
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Método para el menú de figuritas selectivas para crear un círculo
	 */
	void circuloSelectivo() {
		try {
			figuritas.add(new Circulo(pedirDimension("Dame el radio: ")));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Método encargado de pedir la dimensión
	 * @param pide
	 * @return el decimal introducido por teclado
	 */
	private double pedirDimension(String pide) {
		return Teclado.leerDecimal(pide);
	}

	/**
	 * Método para el menú figuritas selectivas para crear un cuadrado
	 */
	void cuadradoSelectivo() {
		try {
			figuritas.add(new Cuadrado(pedirDimension("Dame el lado: ")));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}
	
	/**
	 * Método para el menú figuritas selectivas para crear un rectángulo
	 */

	void rectanguloSelectivo() {
		try {
			figuritas.add(new Rectangulo(pedirDimension("Dame la base: "), pedirDimension("Dame la altura: ")));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Método para el menú figuritas selectivas para crear un triángulo
	 */
	void trianguloSelectivo() {
		try {
			figuritas.add(new Triangulo(pedirDimension("Dame la base: "), pedirDimension("Dame la altura: ")));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}
	/**
	 * Método encargado de dar baja por identificador
	 * @param identificador
	 * @throws FiguraNoExisteException
	 */
	void bajaIdentificador(int identificador) throws FiguraNoExisteException {
		if (!figuritas.remove(new Circulo(identificador)))
			throw new FiguraNoExisteException("La figura no existe!");

	}

	/**
	 * Método encargado de dar baja por índice
	 * @param indice
	 * @return el objeto borrado por índice
	 * @throws FiguraNoExisteException
	 */
	FiguraCerrada bajaIndice(int indice) throws FiguraNoExisteException {
		try {
			return figuritas.remove(indice);
		} catch (Exception e) {
			throw new FiguraNoExisteException("La figura no existe!");
		}
	}
	/**
	 * Método encargado de crear el menú para borrar las figuras por índice
	 * @return el array de cadenas para crear el menú
	 */
	public String[] generarOpcionesMenu() {
		String[] opciones = new String[figuritas.size()];
		int i = 0;
		for (FiguraCerrada figura : figuritas) {
			opciones[i] = figura.toString();
			i++;
		}

		return opciones;
	}

}
