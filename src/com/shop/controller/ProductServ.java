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
import com.shop.utils.PersonalException;

/**
 * Servlet implementation class ProductServ
 */
@WebServlet("/ProductServ")
public class ProductServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		int paNo = Integer.parseInt(pageNo);
		int paSize = Integer.parseInt(pageSize);
		ProductService ps = new ProductService();
		try {
			PageModel<ProductBean> pm = ps.queryPage(paNo, paSize);
			if(pm!=null)
			{	
				System.out.println(paSize);
				int totalPageSize = (pm.getCounts()%paSize==0?pm.getCounts()/paSize:pm.getCounts()/paSize+1);
				System.out.println(totalPageSize);
				pm.setAllPages(totalPageSize);
				pm.setCurrentPageNo(paNo);
				request.setAttribute("msgs",pm );
				request.getRequestDispatcher("weicome.jsp").forward(request, response);
			}
		} catch (PersonalException e) {
			e.printStackTrace();
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
