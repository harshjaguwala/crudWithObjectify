package com.EmployeeObjectify.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.EmployeeObjectify.model.EmployeeModel;
import com.EmployeeObjectify.objectify.OfyFactory;
import com.googlecode.objectify.Objectify;


/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet(name = "EmployeeServlet", urlPatterns = { "/" })
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) 
		{
			case "/showRegisterPage":
				try 
				{
					showRegisterPage(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;
			case "/insertEmployeeInfo":
				try 
				{
					insertEmployeeInfo(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "/deleteemployeeinfo":
				try 
				{
					deleteemployeeinfo(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "/editEmployeeInfo":
				try {
					editEmployeeInfo(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "/updateEmployeeInfo":
				try {
					updateEmployeeInfo(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "/searchByName":
				try {
					searchByName(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			default:
				try {
					showallEmployee(request, response);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;
		}
	}

	public void showRegisterPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("hello");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/showRegisterPage.jsp");
		rd.forward(request, response);
	}
	
	public void insertEmployeeInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("this is employee insert method");
		String name = request.getParameter("name");
		System.out.println("name " + name);
		int age = Integer.parseInt(request.getParameter("age"));
		
		EmployeeModel employeeModel = new EmployeeModel(name, age);
		Objectify ofy = OfyFactory.init();
		ofy.save().entities(employeeModel).now();
		showallEmployee(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/showAllEmployee.jsp");
		rd.forward(request, response);
	}
	
	private void deleteemployeeinfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		Long bid = Long.parseLong(request.getParameter("id"));
		Objectify ofy = OfyFactory.init();
		EmployeeModel employeeModel = ofy.load().type(EmployeeModel.class).id(bid).now();
		ofy.delete().entity(employeeModel).now();
		response.sendRedirect("Showalluser");
	}
	
	private void editEmployeeInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Objectify ofy = OfyFactory.init();
		EmployeeModel existingEmp = ofy.load().type(EmployeeModel.class).id(id).now();
		System.out.println("exist " + existingEmp);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/showRegisterPage.jsp");
		request.setAttribute("existingEmp", existingEmp);
		rd.forward(request, response);
	}
	
	private void updateEmployeeInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		Long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		EmployeeModel employeeModel = new EmployeeModel(id,name, age);
		Objectify ofy = OfyFactory.init();
		ofy.save().entities(employeeModel).now();
		response.sendRedirect("Showalluser");
	}
	
	private void searchByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String searchByName = request.getParameter("SearchName");
		System.out.println("searchByName " + searchByName);
		Objectify ofy = OfyFactory.init();
		List<EmployeeModel> mathingEmployee = ofy.load().type(EmployeeModel.class).filter("name",searchByName).list();
		System.out.println(mathingEmployee);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/showAllEmployee.jsp");
		rd.forward(request, response);
	}
	
	private void showallEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		Objectify ofy = OfyFactory.init();
		List<EmployeeModel> listofempinfo = ofy.load().type(EmployeeModel.class).list();
		//List<EmployeeModel> listofempinfo = ObjectifyService.ofy().load().type(EmployeeModel.class).list();
		System.out.println("list of emp ifor is " + listofempinfo);
		request.setAttribute("listofempinfo", listofempinfo);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/showAllEmployee.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
