package discoMusical;

import java.util.Scanner;

/**
 * 
 * Considera estás desarrollando un programa Java donde necesitas trabajar con
 * objetos de tipo DiscoMusical. Define las signaturas para métodos dentro dicha
 * clase e indica si deberán ser procedimientos o funciones para los siguientes
 * objetivos planteados:
 * 
 * 1) Obtener la duración de una canción expresada como un número decimal en
 * minutos (por ejemplo podría ser 3,22 minutos) recibiendo como dato el número
 * de canción dentro del disco.
 * 
 * 2) Pedir a un administrador de una compañía discográfica que introduzca la
 * duración de todas las canciones (dichas duraciones se almacenarán como
 * información del objeto). Es decir, el método se encargará de saludar al
 * usuario y pedirle que vaya introduciendo una por una la duración de las
 * canciones.
 * 
 * 3) Obtener la duración del disco completo (suma de las duraciones de cada una
 * de las canciones).
 * 
 * 4) Añadir una canción al disco recibiendo como información para ello el
 * título de la canción y su duración (se añadirá como última canción en el
 * disco. Si el disco tenía por ejemplo 10 canciones, al añadirse una canción
 * pasará a tener 11).
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

		System.out.println("\n************\n   MENÚ  \n************\n1.- Ingresar una canción al Disco \n" + "2.- Obtener la duración del disco \n"
				+ "3.- Obtener la duración de una canción del disco [i] \n" + "4.- Mostrar el listado de canciones \n"
				+ "0.- Ingrese el número 0 para terminar");

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
				System.out.println("Duración del disco: " + disco.getDuracionDisco());
				break;

			case 3:
				if (!disco.getListaCanciones().isEmpty()) {
					System.out.println("Introduzca el número de canción:");
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
			System.out.println("-------------------------\nNúm. | Nombre\n-------------------------");
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
			System.out.print("Por favor, ingrese el nombre de la canción que desea añadir:\n");
			String inName = teclado.nextLine();
			track.setNombreCancion(inName);
		} catch (Exception e1) {
			System.out.println("error ingresando nombre de la cancion: " + e1);
		}

		try {
			System.out.print("Por favor, ingrese la duración de la canción:\n");
			double inDuration = teclado.nextDouble();
			double duration = inDuration;
			track.setDuracionCancion(duration);

		} catch (NumberFormatException e2) {
			System.out.println("error ingresando duracion de la cancion: " + e2);
		}
		
		System.out.println("Canciones antes: " + disco.getListaCanciones().size());
		disco.setListaCanciones(track);
		System.out.println("Canciones después: " + disco.getListaCanciones().size());
		
	}

}
