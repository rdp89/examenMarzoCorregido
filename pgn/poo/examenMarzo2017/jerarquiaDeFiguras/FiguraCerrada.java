package pgn.poo.examenMarzo2017.jerarquiaDeFiguras;

import pgn.poo.examenMarzo2017.excepciones.DimensionNoValidaException;

public abstract class FiguraCerrada {
	private int identificador = 1;
    private static int contador = 1;
	
	public FiguraCerrada(){
		setIdentificador(generarId());
	}
	
	

	private int generarId() {
		return contador++;
	}



	public FiguraCerrada(int identificador){
		this.setIdentificador(identificador);
	}
	
	protected boolean dimensionValida(double base) throws DimensionNoValidaException {
		if (base < 0.5)
			throw new DimensionNoValidaException("No puedes crear el " + getClass().getSimpleName() + ", has intentado crearlo con una dimensión de " + base
					+ ". La dimensión ha de tener un mínimo de 0.5");

		return true;
}
	
	protected abstract double area();
	protected abstract double perimetro();



	public int getIdentificador() {
		return identificador;
	}



	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}
