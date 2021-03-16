package com.bvn.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvn.crud.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Product findByName(String name);

}
