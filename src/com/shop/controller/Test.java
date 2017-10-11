package com.shop.controller;

import java.util.Enumeration;
import java.util.UUID;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
		String s = UUID.randomUUID().toString();//用来生成数据库的主键id非常不错..
		System.out.println(s.substring(0, 8));
	
	}
}
