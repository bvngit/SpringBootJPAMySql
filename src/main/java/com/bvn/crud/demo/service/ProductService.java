package com.bvn.crud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvn.crud.demo.entity.Product;
import com.bvn.crud.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	public String deleteProduct(int id) {
		repository.deleteById(id);
		
		return "Product[" + id + "] removed!!";
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct = getProductById(product.getId());
		
		if( existingProduct == null ) 
			return null;
			
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		
		return this.saveProduct(existingProduct);
		
	}
}
