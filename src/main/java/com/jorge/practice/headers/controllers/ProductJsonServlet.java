package com.jorge.practice.headers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebServlet({"/products-json"})
public class ProductJsonServlet extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        resp.setContentType("application/json; charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(products);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.readValue(req.getInputStream(), Product.class);
        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Created Product</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Created Product</h1>");
            out.println("<p>The product was created successfully!</p>");
            out.println("<ul>");
            out.println("<li>Id : " + product.getId() + "</li>");
            out.println("<li>Name : " + product.getName() + "</li>");
            out.println("<li>Type : " + product.getType() + "</li>");
            out.println("<li>Price : " + product.getPrice() + "</li>");
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
}
