package com.kush.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kush.model.dao.ItemCRUD;
import com.kush.model.entity.Item;

/**
 * Servlet implementation class ViewItemController
 */
public class ViewItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("opt");
		ItemCRUD crud = new ItemCRUD();
		try {
			Item item = crud.searchItemById(id);
			File file=new File(getServletContext().getRealPath(item.getItemImageName()));
			FileOutputStream stream=new FileOutputStream(file);
			stream.write(item.getItemImageData());
			stream.close();
			request.setAttribute("FileName",item.getItemImageName());
			request.setAttribute("Item", item);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("ViewItem.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
