package org.example.bt_hoanthienbaigiohang.service;

import org.example.bt_hoanthienbaigiohang.model.Product;

public interface IProductService {
    Iterable<Product> findAll();

    Product findById(Long id);
}
