package Models;

public class Pokemon {

	@Override
	public String toString() {
		return "Pokemon [id_pokemon=" + id_pokemon + ", nombre=" + nombre + ", altura=" + altura + ", categoria="
				+ categoria + ", peso=" + peso + ", descripcion=" + descripcion + ", habilidad=" + habilidad
				+ ", tipo=" + tipo + "]";
	}

	private int id_pokemon;
	private String nombre;
	private float altura;
	private String categoria;
	private float peso;
	private String descripcion;
	private String habilidad;
	private String tipo;
	private String imagen;
	private String gif;
	private String sonido;
	

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getGif() {
		return gif;
	}

	public void setGif(String gif) {
		this.gif = gif;
	}

	public String getSonido() {
		return sonido;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

	public Pokemon(int id_pokemon, String nombre, float altura, String categoria, float peso, String descripcion,
			String habilidad, String tipo, String imagen, String gif, String sonido) {
		super();
		this.id_pokemon = id_pokemon;
		this.nombre = nombre;
		this.altura = altura;
		this.categoria = categoria;
		this.peso = peso;
		this.descripcion = descripcion;
		this.habilidad = habilidad;
		this.tipo = tipo;
		this.imagen=imagen;
		this.gif=gif;
		this.sonido=sonido;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId_pokemon() {
		return id_pokemon;
	}

	public void setId_pokemon(int id_pokemon) {
		this.id_pokemon = id_pokemon;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}
}
