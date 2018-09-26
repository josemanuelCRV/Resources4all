package modelos;

import modelos.Persona;

public class Main {

	public static void main(String args[]) {

		Persona persona = new Persona();

		// System.out.println(persona.getNombre());

		persona.setNombre("jose");
		persona.setApellidos("CRV");
		persona.setEdad(34);
		persona.setDni("12345678A");
		persona.setCasado(false);

		System.out.println(
				persona.getNombre() + " " + persona.getApellidos() + " y tengo " + persona.getEdad() + " años");

	}

}
