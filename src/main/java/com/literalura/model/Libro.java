package com.literalura.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String titulo;
	private int numeroDescargas;
	@ManyToOne(cascade = CascadeType.ALL)
	private Autor autor;
	
	@Enumerated(EnumType.STRING)
	private Lenguage lenguage;
	
	
	

	public Libro() {
		super();
	}



	@Override
	public String toString() {
		return "\n________Libro________"
				+ "\nTitulo: " + titulo 
				+ "\nNumero de descargas: " + numeroDescargas 
				+ "\nAutor: "+ autor.getNombre()
				+ "\nIdioma: " + lenguage
				+"\n_____________________\n";
	}
	
	

	public Libro(long id, String titulo, int numeroDescargas, Autor autor, Lenguage lenguage) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.numeroDescargas = numeroDescargas;
		this.autor = autor;
		this.lenguage = lenguage;
	}



	public Libro(DatosLibro datosLibro) {
		this.titulo = datosLibro.titulo();
		this.numeroDescargas = datosLibro.numeroDescargas();
		this.lenguage = Lenguage.fromString(datosLibro.lenguages().get(0).split(",")[0].trim());
		this.autor=new Autor(datosLibro.autores().get(0));

	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public int getNumeroDescargas() {
		return numeroDescargas;
	}



	public void setNumeroDescargas(int numeroDescargas) {
		this.numeroDescargas = numeroDescargas;
	}



	public Autor getAutor() {
		return autor;
	}



	public void setAutor(Autor autor) {
		this.autor = autor;
	}



	public Lenguage getLenguage() {
		return lenguage;
	}



	public void setLenguage(Lenguage lenguage) {
		this.lenguage = lenguage;
	}

	

}
