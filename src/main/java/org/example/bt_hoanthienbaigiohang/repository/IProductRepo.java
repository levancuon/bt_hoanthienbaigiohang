package org.example.bt_hoanthienbaigiohang.repository;

import org.example.bt_hoanthienbaigiohang.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends CrudRepository<Product,Long> , PagingAndSortingRepository<Product,Long> {
}
