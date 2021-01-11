package com.test.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.boot.bean.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	
}
