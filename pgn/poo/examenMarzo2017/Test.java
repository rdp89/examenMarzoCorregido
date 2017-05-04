package pgn.poo.examenMarzo2017;

import pgn.poo.utiles.Menu;
import pgn.poo.utiles.Teclado;
import pgn.poo.examenMarzo2017.excepciones.FiguraNoExisteException;
//import pgn.poo.examenMarzo2017.excepciones.DimensionNoValidaException;
import pgn.poo.examenMarzo2017.excepciones.ListaVaciaException;

//import pgn.poo.examenMarzo2017.jerarquiaDeFiguras.Rectangulo;
/**
 * Examen de marzo corregido
 * 
 * @author Rafael Delgado Peña
 *
 */
public class Test {
	private static String[] opsGeneral = new String[] { "Altas", "Bajas", "Listar" };
	private static Menu menuGeneral = new Menu("Menu general", opsGeneral);
	private static String[] opsAltas = new String[] {
			"Masivas(3 figuras aleatorios de cada tipo con dimensiones aleatorias)",
			"Selectivas(dimensiones por teclado)" };
	private static Menu menuAltas = new Menu("Menu de altas", opsAltas);
	private static String[] opsSelectivas = new String[] { "Círculo", "Cuadrado", "Rectángulo",
			"Triángulo rectángulo" };
	private static Menu menuSelectivas = new Menu("Elige una figura a crear", opsSelectivas);
	private static String[] opsListar = new String[] { "Todos", "Triángulos", "Del revés" };
	private static Menu menuListar = new Menu("Menú listar", opsListar);
	private static String[] opsBajas = new String[] { "Por identificador", "Por índice de la lista" };
	private static Menu menuBajas = new Menu("Menu bajas", opsBajas);

	static Figuras figuritas = new Figuras();

	public static void main(String[] args) {
		do {
			switch (menuGeneral.gestionar()) {
			case 1:
				altasFigura();
				break;

			case 2:
				bajasFiguras();
				break;

			case 3:
				listarFiguras();
				break;

			default:
				System.out.println("\nSaliendo del programa...");
				return;
			}
		} while (true);

	}

	/**
	 * Metodo encargado de abrir el menu para listar figuras
	 */

	private static void listarFiguras() {
		do {
			switch (menuListar.gestionar()) {
			case 1:
				try {
					System.out.println(figuritas.mostrarFiguritas());
				} catch (ListaVaciaException e) {
					System.err.println(e.getMessage());
				}
				break;

			case 2:
				try {
					System.out.println(figuritas.mostrarTriangulos());
				} catch (ListaVaciaException e) {
					System.err.println(e.getMessage());
				}
				break;

			case 3:
				try {
					System.out.println(figuritas.mostrarDelReves());
				} catch (ListaVaciaException e) {
					System.err.println(e.getMessage());
				}
				break;

			default:
				System.out.println("\nSaliendo del programa...");
				return;
			}
		} while (true);

	}

	/**
	 * Método encargado de abrir menu para las bajas de las figuras
	 */

	private static void bajasFiguras() {
		if (figuritas.isEmpty()) {
			System.err.println("La lista está vacía");
			return;
		}

		do {
			switch (menuBajas.gestionar()) {
			case 1:
				bajaIdentificador();
				break;

			case 2:
				bajaIndice();
				break;

			default:
				return;
			}
		} while (true);

	}

	/**
	 * Método encargado de la baja por índice
	 */

	private static void bajaIndice() {
		Menu menu = new Menu("Escoja una figura", figuritas.generarOpcionesMenu());
		try {
			System.out.println("Se ha borrado: " + figuritas.bajaIndice(menu.gestionar() - 1));
		} catch (FiguraNoExisteException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Método encargado de la baja por indentificador Nota: No me funciona
	 */

	private static void bajaIdentificador() {
		try {
			System.out.println(figuritas.mostrarFiguritas());
		} catch (ListaVaciaException e) {
			System.err.println(e.getMessage());
		}
		try {
			figuritas.bajaIdentificador(pedirIdentificador());
		} catch (FiguraNoExisteException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Metodo encargado de pedir el identificador
	 * 
	 * @return el identificador introducido por teclado
	 */
	private static int pedirIdentificador() {
		return Teclado.leerEntero("Dame el identificador de la figura que desea borrar: ");
	}

	/**
	 * Método que abre el menú para dar de altas a las figuras
	 */
	private static void altasFigura() {
		do {
			switch (menuAltas.gestionar()) {
			case 1:
				altaMasiva();
				break;

			case 2:
				altaSelectiva();
				break;

			default:
				return;
			}
		} while (true);

	}

	/**
	 * Método encargado de abrir el menú de las altas selectivas
	 */
	private static void altaSelectiva() {
		do {
			switch (menuSelectivas.gestionar()) {
			case 1:
				figuritas.circuloSelectivo();
				break;

			case 2:
				figuritas.cuadradoSelectivo();
				break;

			case 3:
				figuritas.rectanguloSelectivo();
				break;
			case 4:
				figuritas.trianguloSelectivo();
				break;
			default:
				return;
			}
		} while (true);

	}
	
	/**
	 * Método encargado de las altas masivas
	 */
	
	private static void altaMasiva() {
		figuritas.altasMasivas();

	}

}
