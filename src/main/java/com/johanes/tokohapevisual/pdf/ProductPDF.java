/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.johanes.tokohapevisual.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author acer
 */
public class ProductPDF {
     public static void main(String[] args) throws Exception{
                
                /* Create Connection objects */
               
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/si_tokohp", "root", "");
                Statement stmt = conn.createStatement();
                /* Define the SQL query */
                ResultSet query_set = stmt.executeQuery("Select * from product_hp");
                /* Step-2: Initialize PDF documents - logical objects */
                Document my_pdf_report = new Document();
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Report_Produk.pdf"));
                my_pdf_report.open();            
                //we have seven columns in our table
                PdfPTable my_report_table = new PdfPTable(6);
                //create a cell object
                PdfPCell table_cell;
                
               
                table_cell=new PdfPCell(new Phrase("ID Produk"));
                my_report_table.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase("Kategori Produk"));
                my_report_table.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase("Nama Produk"));
                my_report_table.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase("Harga"));
                my_report_table.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase("Kuantitas"));
                my_report_table.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase("Gambar"));
                my_report_table.addCell(table_cell);
                
                while (query_set.next()) { 
                    
                                int productId = query_set.getInt("productId");
                                table_cell=new PdfPCell(new Phrase(Integer.toString(productId)));
                                my_report_table.addCell(table_cell);
                                
                                String productCategory=query_set.getString("productCategory");
                                table_cell=new PdfPCell(new Phrase(productCategory));
                                my_report_table.addCell(table_cell);
                                
                                String productName =query_set.getString("productName");
                                table_cell=new PdfPCell(new Phrase(productName));
                                my_report_table.addCell(table_cell);
                                
                                double price=query_set.getDouble("price");
                                table_cell=new PdfPCell(new Phrase(Double.toString(price)));
                                my_report_table.addCell(table_cell);
                                
                                int qty = query_set.getInt("qty");
                                table_cell=new PdfPCell(new Phrase(Integer.toString(qty)));
                                my_report_table.addCell(table_cell);
                                String gambar = query_set.getString("gambar");
                                table_cell=new PdfPCell(new Phrase(gambar));
                                my_report_table.addCell(table_cell);
                                
                               
                                
                                }
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);                       
                my_pdf_report.close();
                
                /* Close all DB related objects */
                query_set.close();
                stmt.close(); 
                conn.close();               
                
        }
    public static void PDF() throws Exception{
        main(null);
    }
    
}
