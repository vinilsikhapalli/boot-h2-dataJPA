package com.test.boot.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.boot.bean.Product;
import com.test.boot.service.ProductService;

@RestController
public class BootCotroler {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product produc) {
		Product product = productService.SaveData(produc);
		System.out.println(product);
		return product;
	}
	
	@GetMapping("/")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/get/{prId}")
	public Product getProductByProductId(@PathVariable("prId") Integer productId) {
		return productService.getProductByProductId(productId);
	}
	
	@PatchMapping("/update")
	public Product updateProduct( @RequestBody Product product){
		
		return productService.updateProduct(product);
	}
	
	@PatchMapping("/delete/{id}")
	public Boolean updateProduct(@PathVariable("id") Integer productId) {
		
		return productService.deleteProductByProductId(productId);
	}
	
}
