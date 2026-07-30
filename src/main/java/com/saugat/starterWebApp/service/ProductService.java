package com.saugat.starterWebApp.service;

import com.saugat.starterWebApp.model.Product;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Service
public class ProductService {

    private List<Product> products= new ArrayList<>(Arrays.asList(
            new Product(101,"Calculator", 100),
            new Product(102, "Laptop", 100000),
            new Product(103, "Fan", 5000)
    ));


    public Product getProductById(int id) {
        return products.stream().filter(product ->product.getProdID()==id)
                .findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    public void addProduct(Product product) {
        products.add(product);
    }


    public void updateProduct(Product product) {

        products.set(getIndex(product.getProdID()), product);

    }
    public int getIndex(int id){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getProdID()==id){
                return i;
            }
        }
        return -1;
    }

    public void deleteProductById(int prodId) {
        products.remove(getIndex(prodId));
    }
}
