package com.literalura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.literalura.model.Libro;
import com.literalura.model.Lenguage;


@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
	
	List<Libro> findByLenguage(Lenguage lenguage);
	Optional<Libro> findByTitulo(String titulo);

}
