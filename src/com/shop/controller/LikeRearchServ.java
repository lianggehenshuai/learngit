package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.PageModel;
import com.shop.entity.ProductBean;
import com.shop.services.ProductService;

/**
 * Servlet implementation class LikeRearchServ
 */
@WebServlet("/LikeRearchServ")
public class LikeRearchServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeRearchServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String input = request.getParameter("rearchInput");
		System.out.println(input);
		ProductService ps = new ProductService();
		PageModel<ProductBean> pm = ps.queryProByName(input);
		System.out.println(pm.getPageInfo());
		if(pm!=null)
		{
			
			request.setAttribute("pm", pm);
			request.getRequestDispatcher("weicome2.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
