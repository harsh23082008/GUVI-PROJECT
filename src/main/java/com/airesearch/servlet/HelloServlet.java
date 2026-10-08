package com.airesearch.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<!doctype html><html lang='en'><meta charset='utf-8'><title>Servlet status</title><body><main><h1>Servlet application is running</h1><p>The request reached HelloServlet on Apache Tomcat.</p><p><a href='" + request.getContextPath() + "/'>Return to the platform home page</a></p></main></body></html>");
    }
}
