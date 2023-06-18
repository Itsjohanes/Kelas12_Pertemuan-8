    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.johanes.tokohapevisual.model;

    /**
     *
     * @author Johannes Alexander Putra, CSCU
     */
    public class Product {
        private int productId;
        private String productCategory;
        private String productName;
        private double price;
        private int qty;
        private String gambar;

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getProductCategory() {
            return productCategory;
        }

        public void setProductCategory(String productCategory) {
            this.productCategory = productCategory;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }
        public String getGambar() {
            return gambar;
        }
        public void setGambar(String gambar){
            this.gambar = gambar;
        }

    }
