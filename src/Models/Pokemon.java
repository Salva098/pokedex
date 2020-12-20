package Models;

public class Pokemon {

	private int id_pokemon;
	private String nombre;
	private float altura;
	private String categoria;
	private float peso;
	private String descripcion;
	private String habilidad;
	private String sonido;

	public Pokemon(int id_pokemon, String nombre, float altura, String categoria, float peso, String descripcion,
			String habilidad, String sonido) {
		this.id_pokemon = id_pokemon;
		this.nombre = nombre;
		this.altura = altura;
		this.categoria = categoria;
		this.peso = peso;
		this.descripcion = descripcion;
		this.habilidad = habilidad;
		this.sonido = sonido;
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

	public String getSonido() {
		return sonido;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

}
