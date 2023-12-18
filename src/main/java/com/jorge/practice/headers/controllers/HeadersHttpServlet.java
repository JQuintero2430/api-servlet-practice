package com.jorge.practice.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/headers-request")
public class HeadersHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Headers Http Request</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Headers Http Request!</h1>");
            out.println("<ul>");
            out.println("<li>Method : " + req.getMethod() + "</li>");
            out.println("<li>Protocol : " + req.getProtocol() + "</li>");
            out.println("<li>Request URI : " + req.getRequestURI() + "</li>");
            out.println("<li>Request URL : " + req.getRequestURL() + "</li>");
            out.println("<li>Context Path : " + req.getContextPath() + "</li>");
            out.println("<li>Servlet Path : " + req.getServletPath() + "</li>");
            req.getHeaderNames()
                    .asIterator()
                    .forEachRemaining(headerName -> out.println("<li>" + headerName + " : " + req.getHeader(headerName) + "</li>"));
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}