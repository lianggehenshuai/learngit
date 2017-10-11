package com.shop.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.shop.entity.AddressBean;
import com.shop.services.AddRessService;
import com.shop.utils.Escape;

/**
 * Servlet implementation class ReadAddressServ
 */
@WebServlet("/ReadAd3")
public class ReadAddressServ3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadAddressServ3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String paraValue= Escape.unescape(request.getParameter("addee").toString().trim());
		/*String adde = URLDecoder.decode(add,"utf-8");*/
		/*System.out.println("µØÖ·Îª:"+paraValue);*/
		//String add = request.getParameter("add");
		AddRessService ars = new AddRessService();
		List<AddressBean> list = ars.queryAddByCity(paraValue);
		Gson gs = new Gson();
		String responseText  = gs.toJson(list);
		response.getWriter().println(responseText);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
