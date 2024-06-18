package com.Grupo33.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Grupo33.entities.Lote;

@Repository("loteRepository")
public interface ILoteRepository extends JpaRepository <Lote, Integer> {

	public abstract Lote getById(int id);
	
	@Query("SELECT l FROM Lote l JOIN FETCH l.producto p WHERE p.id =:idProduct")
	public List<Lote> findByProductIdProduct(int idProduct);
}
