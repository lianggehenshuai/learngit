package com.shop.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.entity.UsersBean;
import com.shop.services.UserService;

/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession hs = request.getSession();
		String username = request.getParameter("loginName");
		String password = request.getParameter("password");
		UserService us = new UserService();
		UsersBean ub  = new UsersBean(username, password, System.currentTimeMillis(), System.currentTimeMillis(), request.getRemoteAddr());
		UsersBean user = us.addUsers(ub);
		if(user!=null)
		{
			request.setAttribute("user", user);
			hs.setAttribute("user", user);
			request.getRequestDispatcher("ProductServ?pageNo=1&pageSize=8").forward(request, response);
			/*System.out.println(hs.getAttribute("user"));*/
		}else
		{
			System.out.println("×¢²áÊ§°Ü");
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
