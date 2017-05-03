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

public class Figuras {
	private ArrayList<FiguraCerrada> figuritas = new ArrayList<FiguraCerrada>();
	Aleatorio aleatorio = new Aleatorio();

	void add(FiguraCerrada figura) {
		figuritas.add(figura);
	}

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

	boolean isEmpty() {
		return figuritas.isEmpty();
	}

	void altasMasivas() {
		for (int i = 0; i < 3; i++) {
			anadirCircunferencia();
			anadirCuadrado();
			anadirRectangulo();
			anadirTriangulo();
		}
	}

	private void anadirTriangulo() {
		try {
			figuritas.add(new Triangulo(aleatorio.getAleatorio(), aleatorio.getAleatorio()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	private void anadirRectangulo() {
		try {
			figuritas.add(new Rectangulo(aleatorio.getAleatorio(), aleatorio.getAleatorio()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	private void anadirCuadrado() {
		try {
			figuritas.add(new Cuadrado(aleatorio.getAleatorio()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	private void anadirCircunferencia() {
		try {
			figuritas.add(new Circulo(aleatorio.getAleatorio()));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	void circuloSelectivo() {
		try {
			figuritas.add(new Circulo(pedirDimension("Dame el radio: ")));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	private double pedirDimension(String pide) {
		return Teclado.leerDecimal(pide);
	}

	void cuadradoSelectivo() {
		try {
			figuritas.add(new Cuadrado(pedirDimension("Dame el lado: ")));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	void rectanguloSelectivo() {
		try {
			figuritas.add(new Rectangulo(pedirDimension("Dame la base: "), pedirDimension("Dame la altura: ")));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	void trianguloSelectivo() {
		try {
			figuritas.add(new Triangulo(pedirDimension("Dame la base: "), pedirDimension("Dame la altura: ")));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	void bajaIdentificador(int identificador) throws FiguraNoExisteException {
		if (!figuritas.remove(new Circulo(identificador)))
			throw new FiguraNoExisteException("La figura no existe!");

	}

	FiguraCerrada bajaIndice(int indice) throws FiguraNoExisteException {
		try {
			return figuritas.remove(indice);
		} catch (Exception e) {
			throw new FiguraNoExisteException("La figura no existe!");
		}
	}

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
