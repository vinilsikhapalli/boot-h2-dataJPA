package com.test.boot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.boot.bean.Product;
import com.test.boot.dao.ProductDao;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	
	public Product SaveData(Product product) {
		product.setDeleted(false);
		return productDao.save(product);
	}
	
	public List<Product> getAllProducts(){
	
		List<Product> getAll = productDao.findAll();
		 return getAll.stream().filter( data -> data.getDeleted() == false).collect(Collectors.toList());

	}
	
	public Product getProductByProductId(Integer productId) {
		
			return productDao.findById(productId).orElse(null);

	}
	
	
	public Product updateProduct(Product product) {
	
		Product pr =  productDao.findById(product.getProductId()).orElse(null);
		if(product.getProductName() != null)
			pr.setProductName(product.getProductName());
		if(product.getProductPrice() != null)
		pr.setProductPrice(product.getProductPrice());
		return productDao.save(pr);
		
	}
	
	
	public Boolean deleteProductByProductId(Integer productId) {
		
		Product pr =  productDao.findById(productId).orElse(null);
		if(pr != null)
			pr.setDeleted(true);
		productDao.save(pr);
		
		return true;
		
	}
}

