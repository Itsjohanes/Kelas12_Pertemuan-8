/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johanes.tokohapevisual.DAO;

import com.johanes.tokohapevisual.DB.ConnectionDB;
import com.johanes.tokohapevisual.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Johannes Alexander Putra, CSCU
 */
public class ProductDAOImp implements ProductDAO {

    @Override
    public void insert(Product product) {
        try {
            Connection conDB =  ConnectionDB.getConnection();
            String sql = "INSERT INTO product_hp (productCategory,productName,price,qty,gambar) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setString(1, product.getProductCategory());
            ps.setString(2, product.getProductName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQty());
            ps.setString(5, product.getGambar());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data has been saved");
        }  
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot insert into table");
        }
    }   

    @Override
    public void update(Product product) {
        try {
            Connection conDB =  ConnectionDB.getConnection();
            String sql = "UPDATE product_hp SET productCategory =?, productName=?, price=?, qty=?, gambar=? WHERE productId=?";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setString(1, product.getProductCategory());
            ps.setString(2, product.getProductName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQty());
            ps.setString(5, product.getGambar());
            ps.setInt(6, product.getProductId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data has been update");
        }  
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot update into table");
        }
    }   

    @Override
    public void delete(Product product) {
        try {
            Connection conDB =  ConnectionDB.getConnection();
            String sql = "DELETE FROM product_hp WHERE productId=?";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setInt(1, product.getProductId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data has been delete");
        }  
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot update into table");
        }
    }   

    @Override
    public Product getProduct(int productId) {
        Product product = new Product();
        try {
            Connection conDB = ConnectionDB.getConnection();
            String sql = "SELECT * FROM product_hp WHERE productId=?";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                product.setProductId(rs.getInt("productId"));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getInt("price"));
                product.setQty(rs.getInt("qty"));
                product.setGambar(rs.getString("gambar"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot get data from table by using productId");
        }
        return product;
    }

    @Override
    public List<Product> list() {
      
        List<Product> listProduct = new ArrayList<Product>();

        try{
            Connection conDB = ConnectionDB.getConnection();
            String sql = "SELECT * FROM product_hp";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getInt("price"));
                product.setQty(rs.getInt("qty"));
                product.setGambar(rs.getString("gambar"));

                listProduct.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot get data from table");
        }
        return listProduct;
    }

    @Override
    public List<Product> listByID(int productId) {

        List<Product> listProduct = new ArrayList<Product>();

        try{
            Connection conDB = ConnectionDB.getConnection();
            String sql = "SELECT * FROM product_hp WHERE productId=?";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getInt("price"));
                product.setQty(rs.getInt("qty"));
                product.setGambar(rs.getString("gambar"));
                listProduct.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot get data from table");
        }
        return listProduct;
    }

}
