package discoMusical;

import java.util.ArrayList;

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

public class DiscoMusical {

	

	private String nombreDisco;
//	private double duracionDisco;
//	private double duracionCancion;
	private ArrayList<Track> listaCanciones = new ArrayList<Track>();

	public DiscoMusical() {
		super();
	}

	public String getNombreDisco() {
		return nombreDisco;
	}

	public double getDuracionDisco() {
		
		double result = 0;
		if  (getListaCanciones().size() > 0) {
			System.out.println("Número de canciones: " + getListaCanciones().size());
			for (int x = 0; x < getListaCanciones().size(); x++) {
			result += getListaCanciones().get(x).getDuracionCancion(); 
			}
		}
		
		return result;
	}

	public ArrayList<Track> getListaCanciones() {
		return listaCanciones;
	}

//	public void getDuracionCancion(int numCancion) {
//		System.out.println("Número de canciones: " + getListaCanciones().size());
//		System.out.println(getListaCanciones().get(numCancion).getDuracionCancion());
//		
////		return duracionCancion;
//	}

	public void setNombreDisco(String nombreDisco) {
		this.nombreDisco = nombreDisco;
	}

//	public void setDuracionDisco(double duracionDisco) {
//		this.duracionDisco += duracionDisco;
//	}

	public void setListaCanciones(Track track) {
		this.listaCanciones.add(track);

	}

	@Override
	public String toString() {
		return "DiscoMusical nombreDisco=" + nombreDisco + ", duracionDisco=" + getDuracionDisco()  
				+ ", listaCanciones=" + listaCanciones.size() + "\n";
	}

}
