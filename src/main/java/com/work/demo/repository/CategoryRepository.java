package com.work.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.work.demo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
