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
 * Servlet implementation class CreateProductServlet
 */
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		Integer price = Integer.parseInt(request.getParameter("price"));
		
		product product1 = new product();
		
		product1.setId(id);
		product1.setDescription(description);
		product1.setName(name);
		product1.setPrice(price);
		
		
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		productbo bo = (productbo) context.getBean("productbo");
		bo.create(product1);

		PrintWriter p = response.getWriter();

		p.print("created");

	}

}
