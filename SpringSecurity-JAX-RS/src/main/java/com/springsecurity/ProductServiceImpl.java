package com.springsecurity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springsecurity.model.Product;
import com.springsecurity.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	List<Product> productList = new ArrayList<>();
	public long id = 0;

	public ProductServiceImpl() {
		Product product = new Product(++id, "Asus");
		productList.add(product);
	}

	@Override
	public List<Product> getProducts() {
		return productList;
	}

	@Override
	public Product addProduct(Product product) {
		product.setId(++id);
		productList.add(product);
		return product;
	}

}
