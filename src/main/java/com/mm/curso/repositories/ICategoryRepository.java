package com.mm.curso.repositories;

import com.mm.curso.entiities.Category;
import com.mm.curso.entiities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
