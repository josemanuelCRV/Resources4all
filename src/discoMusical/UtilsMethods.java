package discoMusical;

import java.util.Scanner;

/**
 * 
 * Considera est�s desarrollando un programa Java donde necesitas trabajar con
 * objetos de tipo DiscoMusical. Define las signaturas para m�todos dentro dicha
 * clase e indica si deber�n ser procedimientos o funciones para los siguientes
 * objetivos planteados:
 * 
 * 1) Obtener la duraci�n de una canci�n expresada como un n�mero decimal en
 * minutos (por ejemplo podr�a ser 3,22 minutos) recibiendo como dato el n�mero
 * de canci�n dentro del disco.
 * 
 * 2) Pedir a un administrador de una compa��a discogr�fica que introduzca la
 * duraci�n de todas las canciones (dichas duraciones se almacenar�n como
 * informaci�n del objeto). Es decir, el m�todo se encargar� de saludar al
 * usuario y pedirle que vaya introduciendo una por una la duraci�n de las
 * canciones.
 * 
 * 3) Obtener la duraci�n del disco completo (suma de las duraciones de cada una
 * de las canciones).
 * 
 * 4) A�adir una canci�n al disco recibiendo como informaci�n para ello el
 * t�tulo de la canci�n y su duraci�n (se a�adir� como �ltima canci�n en el
 * disco. Si el disco ten�a por ejemplo 10 canciones, al a�adirse una canci�n
 * pasar� a tener 11).
 * 
 * @author josem
 *
 */

public class UtilsMethods {

	String nombreCancion;
	double duracionCancion;
	DiscoMusical disco = new DiscoMusical();
	Scanner teclado = new Scanner(System.in);
//	ArrayList<Track> trackList = new ArrayList<Track>();

	public void launch() {

		System.out.println("\n************\n   MEN�  \n************\n1.- Ingresar una canci�n al Disco \n" + "2.- Obtener la duraci�n del disco \n"
				+ "3.- Obtener la duraci�n de una canci�n del disco [i] \n" + "4.- Mostrar el listado de canciones \n"
				+ "0.- Ingrese el n�mero 0 para terminar");

		int key;
		key = teclado.nextInt();

		if (key != 0) {
			inciarProceso(key);
			teclado.close();
		}

	}

	public void inciarProceso(int key) {

		Scanner teclado;
		teclado = new Scanner(System.in);

		try {
			switch (key) {
			case 1:
				ingresarCancion();
				break;

			case 2:
				System.out.println("Duraci�n del disco: " + disco.getDuracionDisco());
				break;

			case 3:
				if (!disco.getListaCanciones().isEmpty()) {
					System.out.println("Introduzca el n�mero de canci�n:");
					int numCancion = teclado.nextInt();
					System.out.println(disco.getListaCanciones().get(numCancion-1).getDuracionCancion());
				} else {
					System.out.println("Disco sin canciones\n");
				}
				break;

				
			case 4:
				showAllList();
				break;

				
			case 0:
				System.out.println("Adios... ;)");
				break;

				
			default:
				teclado.close();
				break;
			}
			launch();

			
		} catch (Exception e) {
			System.out.println("Error case [0]: " + e);
		}
		
	}

	private void showAllList() {
		if (disco.getListaCanciones().size() > 0) {
			System.out.println("Total en Disco: " + disco.getListaCanciones().size());
			System.out.println("-------------------------\nN�m. | Nombre\n-------------------------");
			for (int x = 0; x < disco.getListaCanciones().size(); x++) {
				
				System.out.println( x+1 + "      " + disco.getListaCanciones().get(x).getNombreCancion());
			}
		} else {
			System.out.println("Disco sin canciones");
		}
	}

	
	public void ingresarCancion() {

		teclado = new Scanner(System.in);

		Track track = new Track();
		
		try {
			System.out.print("Por favor, ingrese el nombre de la canci�n que desea a�adir:\n");
			String inName = teclado.nextLine();
			track.setNombreCancion(inName);
		} catch (Exception e1) {
			System.out.println("error ingresando nombre de la cancion: " + e1);
		}

		try {
			System.out.print("Por favor, ingrese la duraci�n de la canci�n:\n");
			double inDuration = teclado.nextDouble();
			double duration = inDuration;
			track.setDuracionCancion(duration);

		} catch (NumberFormatException e2) {
			System.out.println("error ingresando duracion de la cancion: " + e2);
		}
		
		System.out.println("Canciones antes: " + disco.getListaCanciones().size());
		disco.setListaCanciones(track);
		System.out.println("Canciones despu�s: " + disco.getListaCanciones().size());
		
	}

}
