package pgn.poo.examenMarzo2017.jerarquiaDeFiguras;

import pgn.poo.examenMarzo2017.excepciones.DimensionNoValidaException;
import pgn.poo.examenMarzo2017.matematicas.Aleatorio;

public class Triangulo extends FiguraCerrada {
	private double base;
	private double altura;
	private Aleatorio aleatorio = new Aleatorio();

	public Triangulo() throws DimensionNoValidaException {
		setBase(aleatorio.getAleatorio());
		setAltura(aleatorio.getAleatorio());
	}

	public Triangulo(double base, double altura) throws DimensionNoValidaException {
		setBase(base);
		setAltura(altura);
	}

	@Override
	protected double area() {
		return (base * altura) / 2;
	}

	@Override
	protected double perimetro() {
		return base + altura + (Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2)));
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) throws DimensionNoValidaException {
		if (dimensionValida(base))
			this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) throws DimensionNoValidaException {
		if (dimensionValida(base))
			this.altura = altura;
	}

	@Override
	public String toString() {
		return "Triangulo [identificador="+getIdentificador()+" base=" + base + ", altura=" + altura + "] AREA="+area()+" PERÍMETRO="+perimetro();
	}

}
