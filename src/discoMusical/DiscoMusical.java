package discoMusical;

import java.util.ArrayList;

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
			System.out.println("N�mero de canciones: " + getListaCanciones().size());
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
//		System.out.println("N�mero de canciones: " + getListaCanciones().size());
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
