package com.navya.products.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.navya.product.bo.productbo;
import com.navya.product.dto.product;

/**
 * Servlet implementation class DisplayProductServlet
 */
public class DisplayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WebApplicationContext context=WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		productbo bo = (productbo) context.getBean("productbo");
	
		product prod = bo.findproduct(Integer.parseInt(request.getParameter("id")));
		
		PrintWriter p=response.getWriter();
		p.print("produc t details");
		p.print("product id"+prod.getDescription());
		p.print("product id"+prod.getName());p.print("product id"+prod.getPrice());
	}

}
