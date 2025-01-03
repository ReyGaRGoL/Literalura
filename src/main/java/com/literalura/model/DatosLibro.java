package com.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(

		@JsonAlias("title") String titulo, 
		@JsonAlias("download_count") int numeroDescargas,
		@JsonAlias("authors") List<DatosAutor> autores,
		@JsonAlias("languages") List<String> lenguages

) {

}
