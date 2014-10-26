package com.kush.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kush.model.dao.ItemCRUD;
import com.kush.model.entity.Item;

/**
 * Servlet implementation class ItemController
 */
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("opt")!=null)
		{
			if(request.getParameter("opt").equals("view"))
			{
				ItemCRUD crud = new ItemCRUD();
				ArrayList<Item> list = crud.viewItem();
				request.setAttribute("result", list);
				request.getRequestDispatcher("View.jsp").forward(request, response);
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("Entered post");
		if(request.getParameter("search") != null)
		{
			//System.out.println("Entered first if");
			if(request.getParameter("search").equals("Search"))
			{
				//System.out.println("Entered second if");
				try {
					search(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		if(request.getParameter("delete") != null)
		{
			if(request.getParameter("delete").equals("Delete"))
			{
				try {
					delete(request,response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String id = request.getParameter("itemId");
		ItemCRUD crud = new ItemCRUD();
		int result = crud.deleteItem(id);
		request.setAttribute("change", result);
		request.getRequestDispatcher("View.jsp").forward(request, response);
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Entered Search");
		String query = request.getParameter("query");
		ItemCRUD crud = new ItemCRUD();
		ArrayList<Item> list = crud.searchItem(query);
		request.setAttribute("result", list);
		request.getRequestDispatcher("View.jsp").forward(request, response);
	}
	
	

}
