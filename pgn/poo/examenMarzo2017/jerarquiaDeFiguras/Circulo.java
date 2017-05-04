package pgn.poo.examenMarzo2017.jerarquiaDeFiguras;

import pgn.poo.examenMarzo2017.excepciones.DimensionNoValidaException;
//import pgn.poo.examenMarzo2017.matematicas.Aleatorio;

public class Circulo extends FiguraCerrada {
	private double radio;
	private static final double PI = Math.PI;
	//private Aleatorio aleatorio = new Aleatorio();
	
//	public Circulo() throws DimensionNoValidaException {
//		setRadio(aleatorio.getAleatorio());
//	}
//	
	public Circulo(double radio) throws DimensionNoValidaException{
		setRadio(radio);
	}
	
	public Circulo(int identificador) {
		super(identificador);
}
	
	public Circulo() throws DimensionNoValidaException {
		setRadio(Math.random());
	}

	@Override
	protected double area() {
		return PI*(Math.pow(radio, 2));
	}

	@Override
	protected double perimetro() {
		return 2*PI*radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) throws DimensionNoValidaException {
		if(dimensionValida(radio))
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Circulo [identificador="+getIdentificador()+" radio=" + radio + "] AREA="+area()+" PERÍMETRO="+perimetro();
	}
	
	

}
