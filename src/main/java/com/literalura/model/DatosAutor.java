package com.literalura.model;



import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
		@JsonAlias("death_year") int anioFallecimiento,
		@JsonAlias("birth_year") int anioNacimiento,
		@JsonAlias("name") String nombre
		) {

}
