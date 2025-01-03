package com.literalura;


import com.literalura.model.Autor;
import com.literalura.model.Busqueda;
import com.literalura.model.DatosLibro;
import com.literalura.model.Lenguage;
import com.literalura.model.Libro;
import com.literalura.repository.AutorRepository;
import com.literalura.repository.LibroRepository;

import com.literalura.service.ConsumoAPI;
import com.literalura.service.ConvierteDatos;

import java.util.*;


public class Principal {
	
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
            		____________________________________________
            		Elija la opcion a travez de su numero:
            		1 - Buscar libro por titulo 
            		2 - Listar libros registrados
            		3 - Listar autores registrados
            		4 - Listar autores vivos en un determinado año
            		5 - Listar libros por idioma
            		0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                	listarLibrosRegistrados();
                    break;
                case 3:
                	listarAutoresRegistrados();
                    break;
                case 4:
                	listarAutoresVivosPorAnio();
                    break;
                case 5:
                	listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

	private void listarLibrosPorIdioma() {
		
		
		System.out.println("""
				Ingrese el idioma para buscar los libros:
				es- Español
				en- Ingles
				fr- Frances
				pt- Portugues
				""");

		Lenguage lenguage= Lenguage.fromString(teclado.next());
		if (lenguage!=null) {

			List<Libro> libros =new ArrayList<>();
			libros= libroRepository.findByLenguage(lenguage);
			
			libros.forEach(System.out::print);
		}else {
			System.out.println("No se reconoce como un idioma dentro del sistema");
		}
		
		
	}

	private void listarAutoresVivosPorAnio() {

		List<Autor> autores = new ArrayList<>();
		System.out.println("Ingrese el año vivo de autor(es) que desea buscar: ");
		int anio = teclado.nextInt();
		autores= autorRepository.findByAnio(anio);
		autores.forEach(System.out::print);
		
		
	}

	private void listarAutoresRegistrados() {

		List<Autor> autores = new ArrayList<>();
		autores= autorRepository.findAll();
		autores.forEach(System.out::print);
		
	}

	private void listarLibrosRegistrados() {

		List<Libro> libros =new ArrayList<>();
		libros= libroRepository.findAll();
		
		libros.forEach(System.out::print);
	}

	private void buscarLibroPorTitulo() {
		Busqueda busqueda = getDatosLibro();
		
		if(busqueda.resultados().size()>0){
			
			
			
			DatosLibro datosLibro = busqueda.resultados().get(0);
			
			Libro libro = new Libro(datosLibro);
			if (libroRepository.findByTitulo(libro.getTitulo()).isPresent()){
	            System.out.println("\nEl libro ya está registrado.");
	        }else {

				libroRepository.save(libro);
				System.out.println(libro);
	        }
        } else {
            System.out.println("Libro no encontrado");
        }
		
	}
	
	private Busqueda getDatosLibro() {
		System.out.println("Ingresa el titulo del libro que deseas buscar");
        var titulo = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "books/?search="+titulo.replace(" ", "+"));
        Busqueda busqueda = conversor.obtenerDatos(json, Busqueda.class);
        return busqueda;
	}

}

