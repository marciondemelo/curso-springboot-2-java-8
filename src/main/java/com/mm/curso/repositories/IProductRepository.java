package com.mm.curso.repositories;

import com.mm.curso.entiities.Category;
import com.mm.curso.entiities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
