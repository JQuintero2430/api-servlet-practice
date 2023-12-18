package com.jorge.practice.headers.controllers;

import com.jorge.practice.headers.models.Product;
import com.jorge.practice.headers.sevices.IProductService;
import com.jorge.practice.headers.sevices.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/products-xlsx", "/products-html"})
public class ProductXlsxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IProductService productService = new ProductServiceImpl();
        List<Product> products = productService.findAll();
        resp.setContentType("text/html; charset=UTF-8");
        boolean isXlsx = req.getRequestURI().endsWith("xlsx");
        if (isXlsx) {
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment; filename=\"products.xlsx\"");
        }
        try (PrintWriter out = resp.getWriter()) {
            if(!isXlsx){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de Productos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de Productos</h1>");
            out.println("<p><a href=\"" + req.getContextPath() + "/products-xlsx"+ "\">Exportar a Xlsx</a></p>");
            }
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>Name</th>");
            out.println("<th>Type</th>");
            out.println("<th>Price</th>");
            out.println("</tr>");
            products.forEach(product -> {
                out.println("<tr>");
                out.println("<td>" + product.getId() + "</td>");
                out.println("<td>" + product.getName() + "</td>");
                out.println("<td>" + product.getType() + "</td>");
                out.println("<td>" + product.getPrice() + "</td>");
                out.println("</tr>");
            });
            if(!isXlsx){
            out.println("</body>");
            out.println("</html>");
        }}
    }
}
