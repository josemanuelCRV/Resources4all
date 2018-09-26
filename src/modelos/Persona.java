package modelos;

/**
 * 
 * Considera estás desarrollando un programa Java donde necesitas trabajar con
 * objetos de tipo Persona. Define una clase Persona análoga a la que hemos
 * visto para taxis, pero en este caso considerando los siguientes atributos de
 * clase: nombre (String), apellidos (String), edad (int), casado (boolean),
 * numeroDocumentoIdentidad (String). Define un constructor y los métodos para
 * poder establecer y obtener los valores de los atributos. Compila el código
 * para comprobar que no presenta errores. Para comprobar la corrección de tu
 * solución puedes consultar en los foros aprenderaprogramar.com.
 * 
 * 
 * @author josem
 *
 */
public class Persona {
	
	private String nombre;
	private String apellidos;
	private int edad;
	private boolean casado;
	private String dni;
	
	
	public Persona() {
		 
		nombre = "desconocido";
		apellidos = "desconocidos";
		edad = 0;
		casado = false;
		dni = "00000000Z";
	}


	public String getNombre() {
		return "Hola, me llamo " + nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public int getEdad() {
		return edad;
	}


	public boolean isCasado() {
		return casado;
	}


	public String getDni() {
		return dni;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public void setCasado(boolean casado) {
		this.casado = casado;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	

}
