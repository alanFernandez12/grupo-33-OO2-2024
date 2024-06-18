package com.Grupo33.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo33.entities.ItemVenta;


@Repository("ItemVentaRepository")
public interface IItemVentaRepository extends JpaRepository<ItemVenta,Integer> {
	public abstract ItemVenta getById(int id);
}
