package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.entity.ProductBean;

/**
 * Servlet implementation class ShopCarServ
 */
@WebServlet("/ShopCarServ")
public class ShopCarServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCarServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		HttpSession hs = request.getSession();
		if(hs.isNew())
		{
			System.out.println(hs.getId());
		}
		System.out.println(hs.getId());
		/*System.out.println("name:"+request.getParameter("pname"));
		System.out.println("price:"+request.getParameter("price"));
		System.out.println("id:"+request.getParameter("id"));
		System.out.println("count:"+request.getParameter("counts"));*/
		String pname = request.getParameter("pname");
		String price = request.getParameter("price");
		String id = request.getParameter("id");
		String counts = request.getParameter("counts");
		double pri = Double.parseDouble(price);
		int pid = Integer.parseInt(id);
		int count = Integer.parseInt(counts);
		ProductBean pb = new ProductBean(pid, pname, pri, count);
		/*List<ProductBean> list = new ArrayList<>();
		list.add(pb);*/
		hs.setAttribute("pro"+id, pb);
		Boolean result = true;
		request.setAttribute("result", result);
		request.getRequestDispatcher("ProductServ?pageNo=1&pageSize=8").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
