package com.springsecurity.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.springsecurity.model.Product;

@Path(value = "/productservice")
public interface ProductService {
	
	@Path(value="/getproducts")
	@GET
	public List<Product> getProducts();
	
	@Path(value = "/addproduct")
	@POST
	public Product addProduct(Product product);

}
