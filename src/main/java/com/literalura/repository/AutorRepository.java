package com.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.literalura.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {

	@Query("select a from Autor a where a.anioFallecimiento > ?1")
	List<Autor> findByAnio(int anio);
}
