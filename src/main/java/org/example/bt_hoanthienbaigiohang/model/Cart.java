package org.example.bt_hoanthienbaigiohang.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Long> products = new HashMap<>();


    public Cart() {
    }

    public Cart(Map<Product, Long> products) {
        this.products = products;
    }

    public Map<Product, Long> getProduct() {
        return products;
    }

    private boolean checkItemExist(Product product) {
        for (Map.Entry<Product, Long> entry : getProduct().entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Long> selectItem(Product product) {
        for (Map.Entry<Product, Long> entry : getProduct().entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }
    public void addProduct(Product product){
        if(!checkItemExist(product)){
            products.put(product, 1L);
        }
        else {
          Map.Entry<Product,Long> item = selectItem(product);
           Long newQuantity = item.getValue()+1;
           item.setValue(newQuantity);

        }
    }
    public void minusProduct(Product product){
            Map.Entry<Product,Long> item = selectItem(product);
            Long newQuantity = item.getValue()-1;
            if(newQuantity<=0){
                item.setValue(0L);
            }
            else {
                item.setValue(newQuantity);
            }
    }

}
