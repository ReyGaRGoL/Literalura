package com.literalura.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int anioFallecimiento;
	private int anioNacimiento;
	private String nombre;

	@OneToMany(mappedBy = "autor",fetch = FetchType.EAGER)
	private List<Libro> libros;

	
	@Override
	public String toString() {
		
		List<String> titulos=new ArrayList<>();
		libros.forEach(t -> titulos.add(t.getTitulo()));
		return "\n________Autor________"
				+ "\nNombre: " + nombre
				+ "\nAño de Nacimiento: " + anioNacimiento
				+ "\nAño de Nacimiento: "+ anioFallecimiento
				+ "\nLibros: " + titulos
				+"\n_____________________\n";
	}
	


	
	public Autor(long id, int anioFallecimiento, int anioNacimiento, String nombre, List<Libro> libros) {
		super();
		this.id = id;
		this.anioFallecimiento = anioFallecimiento;
		this.anioNacimiento = anioNacimiento;
		this.nombre = nombre;
		this.libros = libros;
	}


	public Autor() {
	}

	public Autor(DatosAutor autor) {

		this.anioFallecimiento = autor.anioFallecimiento();
		this.anioNacimiento = autor.anioNacimiento();
		this.nombre = autor.nombre();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAnioFallecimiento() {
		return anioFallecimiento;
	}

	public void setAnioFallecimiento(int anioFallecimiento) {
		this.anioFallecimiento = anioFallecimiento;
	}

	public int getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(int anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}



}
