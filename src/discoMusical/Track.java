package discoMusical;

public class Track {

	private String nombreCancion;
	private double duracionCancion;

	public Track() {
		super();
	}

	public Track(String nombreCancion, double duracionCancion) {
		super();
		this.nombreCancion = nombreCancion;
		this.duracionCancion = duracionCancion;
	}

	// consultores/observadores
	public String getNombreCancion() {
		return nombreCancion;
	}

	public double getDuracionCancion() {
		return duracionCancion;
	}

	// modificadores
	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

	public void setDuracionCancion(double duration) {
		this.duracionCancion = duration;
	}

}
