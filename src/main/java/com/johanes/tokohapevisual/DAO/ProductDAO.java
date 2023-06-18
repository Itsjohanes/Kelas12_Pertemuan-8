/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.johanes.tokohapevisual.DAO;

import com.johanes.tokohapevisual.model.Product;
import java.util.List;

/**
 *
 * @author Johannes Alexander Putra, CSCU
 */
public interface ProductDAO {
    public void insert(Product product);
    public void update(Product product);
    public void delete(Product product);
    public Product getProduct(int productId);
    public List<Product> list();
    public List<Product> listByID(int productId);
}
