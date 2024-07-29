package org.example.bt_hoanthienbaigiohang.service;

import org.example.bt_hoanthienbaigiohang.model.Product;
import org.example.bt_hoanthienbaigiohang.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepo productRepo;

    @Override
    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }
}
