package pgn.poo.examenMarzo2017.jerarquiaDeFiguras;

import pgn.poo.examenMarzo2017.excepciones.DimensionNoValidaException;
//import pgn.poo.examenMarzo2017.matematicas.Aleatorio;

public class Rectangulo extends FiguraCerrada {
	private double base;
	private double altura;
	//private Aleatorio aleatorio = new Aleatorio();
	

//	public Rectangulo() throws DimensionNoValidaException {
//		setBase(aleatorio.getAleatorio());
//		setAltura(aleatorio.getAleatorio());
//	}


	public Rectangulo(double base, double altura) throws DimensionNoValidaException {
		setBase(base);
		setAltura(altura);
	}

	@Override
	protected double area() {
		return base * altura;
	}

	@Override
	protected double perimetro() {
		return (2 * base) + (2 * altura);
	}

	public double getBase() {
		return base;
	}

	public double getAltura() {
		return altura;
	}


	public void setBase(double base) throws DimensionNoValidaException {
		if(dimensionValida(base))
		this.base = base;
	}


	public void setAltura(double altura) throws DimensionNoValidaException {
		if(dimensionValida(altura))
		this.altura = altura;
	}


	@Override
	public String toString() {
		return "Rectangulo [identificador="+getIdentificador()+" base=" + base + ", altura=" + altura + "] AREA="+area()+" PERÍMETRO="+perimetro();
	}

}
