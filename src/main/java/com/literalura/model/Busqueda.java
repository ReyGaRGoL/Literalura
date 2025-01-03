package com.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Busqueda(
		
		@JsonAlias("results")List<DatosLibro> resultados
		
		) {

}
