package pgn.poo.examenMarzo2017.jerarquiaDeFiguras;

import pgn.poo.examenMarzo2017.excepciones.DimensionNoValidaException;
//import pgn.poo.examenMarzo2017.matematicas.Aleatorio;

public class Cuadrado extends Rectangulo {

	public Cuadrado(double dimension) throws DimensionNoValidaException {
		super(dimension, dimension);
	}

	@Override
	public String toString() {
		return "Cuadrado: identificador="+getIdentificador()+" [ "+super.toString() + ", lado=" + Math.round(getBase()) + "]";
	}
}
