package pgn.poo.examenMarzo2017.jerarquiaDeFiguras;

import pgn.poo.examenMarzo2017.excepciones.DimensionNoValidaException;

public abstract class FiguraCerrada {
	protected int identificador;
    private static int contador = 1;
	
	public FiguraCerrada(){
		setIdentificador(generarId());
	}
	
	

	private int generarId() {
		return contador++;
	}



	public FiguraCerrada(int identificador){
		setIdentificador(identificador);
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + identificador;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(this instanceof FiguraCerrada))
			return false;
		FiguraCerrada other = (FiguraCerrada) obj;
		if (identificador != other.identificador)
			return false;
		return true;
	}
	
}
