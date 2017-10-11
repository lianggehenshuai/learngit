package com.shop.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.ProductBean;

/**
 * Servlet implementation class OrderCommitServ
 */
@WebServlet("/OrderOn")
public class OrderCommitServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCommitServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		/**
		 * ������Ϣ
		 */
		
	/*	String oid = request.getParameter("oid");
		String oAddress = request.getParameter("oAddress");
		String oPhone = request.getParameter("oPhone");
		String payStyle = request.getParameter("payStyle");
		String info = request.getParameter("info");
		
		/**
		 * ��ַ��Ϣ
		 */
	/*	name  varchar(20)  not null, -- �ջ�������
		addr  varchar(200)   not null, -- �ջ��˵�ַ
		phone  varchar(20)   not null, -- ��ϵ��ʽ
		provice  varchar(20)  ,-- ʡ��
		city  varchar(20), -- ��
		area varchar(40),  -- ��/��
		allAddr  varchar(200) -- ��ϸ��Ϣ*/
		String oName = request.getParameter("oName");
		String oPhone = request.getParameter("oPhone");
		String sel2 = request.getParameter("sel2");
		String sel3 = request.getParameter("sel3");
		String sel4 = request.getParameter("sel4");
		String dInfo = request.getParameter("detailInfo");
		System.out.println("�ջ�������:"+oName);
		System.out.println("�ջ��˵绰:"+oPhone);
		System.out.println("�ջ�����Ϣ:"+dInfo);
		System.out.println("ѡ���ʡ��:"+sel2);
		System.out.println("ѡ��ĳ���:"+sel3);
		System.out.println("ѡ��ĵ���:"+sel4);
		
		Enumeration<String> s=request.getSession().getAttributeNames();
		while(s.hasMoreElements()){
		          Object obj =  request.getSession().getAttribute(s.nextElement());
		          if(obj instanceof ProductBean)
		          {
		        	  ProductBean pb = (ProductBean)obj;
		          }
				}

		
	/*	System.out.println("id="+oid);
		System.out.println("oAddress="+oAddress);
		System.out.println("oPhone="+oPhone);
		System.out.println("payStyle="+payStyle);
		System.out.println("info="+info);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
