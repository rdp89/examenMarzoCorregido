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
 * @author Rafael Delgado Pe�a
 *
 */
public class Figuras {
	private ArrayList<FiguraCerrada> figuritas = new ArrayList<FiguraCerrada>();
	Aleatorio aleatorio = new Aleatorio();

	void add(FiguraCerrada figura) {
		figuritas.add(figura);
	}

	/**
	 * M�todo encargado de mostrar todas las figuras que hay en el arraylist
	 * 
	 * @return la cadena con todas las figuras
	 * @throws ListaVaciaException
	 */
	StringBuilder mostrarFiguritas() throws ListaVaciaException {
		if (figuritas.isEmpty())
			throw new ListaVaciaException("La lista figuritas est� vac�a!");

		StringBuilder cadenaFiguritas = new StringBuilder();

		int n = 1;

		for (FiguraCerrada figuraCerrada : figuritas) {
			cadenaFiguritas.append("\n" + n++ + "� " + figuraCerrada);
		}
		return cadenaFiguritas;

	}

	/**
	 * M�todo encargado de mostrar solo los tri�ngulos que hay en el arraylist
	 * 
	 * @return la cadena con los tri�ngulos
	 * @throws ListaVaciaException
	 */
	StringBuilder mostrarTriangulos() throws ListaVaciaException {
		if (figuritas.isEmpty())
			throw new ListaVaciaException("La lista est� vac�a!");

		StringBuilder cadenaTriangulos = new StringBuilder();

		int n = 1;

		for (FiguraCerrada figuraCerrada : figuritas) {
			if (figuraCerrada instanceof Triangulo)
				cadenaTriangulos.append("\n" + n++ + "� " + figuraCerrada);
		}
		return cadenaTriangulos;
	}

	/**
	 * M�todo encargado de mostrar el arraylist del rev�s
	 * 
	 * @return la cadena con el arraylist del rev�s
	 * @throws ListaVaciaException
	 */
	StringBuilder mostrarDelReves() throws ListaVaciaException {
		if (figuritas.isEmpty())
			throw new ListaVaciaException("La lista est� vac�a!");

		StringBuilder cadenaDelReves = new StringBuilder();

		int n = 1;

		ListIterator<FiguraCerrada> it = figuritas.listIterator(figuritas.size());

		while (it.hasPrevious()) {
			cadenaDelReves.append("\n" + n++ + "� " + it.previous());
		}

		return cadenaDelReves;
	}

	/**
	 * M�todo encargado de comprobar si el array list est� vac�o
	 * 
	 * @return true o false
	 */
	boolean isEmpty() {
		return figuritas.isEmpty();
	}

	/**
	 * M�todo encargado de ejecutar las altas masivas
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
	 * M�todo que crea un tri�ngulo
	 */

	private void anadirTriangulo() {
		try {
			figuritas.add(new Triangulo(aleatorio.getAleatorio(), aleatorio.getAleatorio()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * M�todo que crea un rect�ngulo
	 */
	private void anadirRectangulo() {
		try {
			figuritas.add(new Rectangulo(aleatorio.getAleatorio(), aleatorio.getAleatorio()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * M�todo que crea un cuadrado
	 */
	private void anadirCuadrado() {
		try {
			figuritas.add(new Cuadrado(aleatorio.getAleatorio()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * M�todo que crea una circunferencia
	 */
	private void anadirCircunferencia() {
		try {
			figuritas.add(new Circulo());
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * M�todo para el men� de figuritas selectivas para crear un c�rculo
	 */
	void circuloSelectivo() {
		try {
			figuritas.add(new Circulo(pedirDimension("Dame el radio: ")));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * M�todo encargado de pedir la dimensi�n
	 * @param pide
	 * @return el decimal introducido por teclado
	 */
	private double pedirDimension(String pide) {
		return Teclado.leerDecimal(pide);
	}

	/**
	 * M�todo para el men� figuritas selectivas para crear un cuadrado
	 */
	void cuadradoSelectivo() {
		try {
			figuritas.add(new Cuadrado(pedirDimension("Dame el lado: ")));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}
	
	/**
	 * M�todo para el men� figuritas selectivas para crear un rect�ngulo
	 */

	void rectanguloSelectivo() {
		try {
			figuritas.add(new Rectangulo(pedirDimension("Dame la base: "), pedirDimension("Dame la altura: ")));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * M�todo para el men� figuritas selectivas para crear un tri�ngulo
	 */
	void trianguloSelectivo() {
		try {
			figuritas.add(new Triangulo(pedirDimension("Dame la base: "), pedirDimension("Dame la altura: ")));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}
	/**
	 * M�todo encargado de dar baja por identificador
	 * @param identificador
	 * @throws FiguraNoExisteException
	 */
	void bajaIdentificador(int identificador) throws FiguraNoExisteException {
		if (!figuritas.remove(new Circulo(identificador)))
			throw new FiguraNoExisteException("La figura no existe!");

	}

	/**
	 * M�todo encargado de dar baja por �ndice
	 * @param indice
	 * @return el objeto borrado por �ndice
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
	 * M�todo encargado de crear el men� para borrar las figuras por �ndice
	 * @return el array de cadenas para crear el men�
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
