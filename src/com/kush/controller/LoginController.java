package com.kush.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kush.model.bs.ItemManagement;
import com.kush.model.dao.LoginCRUD;
import com.kush.model.entity.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("submit") != null)
		{
			if(request.getParameter("submit").equals("Login"))
			{
				String user=request.getParameter("user");
				String pass=request.getParameter("pass");
				HttpSession session=request.getSession();
				ItemManagement manage=new ItemManagement();
				String role=manage.userLogin(user, pass);
				if(role!=null){
					session.setAttribute("user", role);
					request.getRequestDispatcher("Home.jsp").forward(request, response);
				}
				else{
					request.setAttribute("result", "Wrong userid/password");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
			}
			else if(request.getParameter("submit").equals("Register"))
			{
				String email = request.getParameter("email");
				String pass = request.getParameter("pass");
				String phone = request.getParameter("phone");
				String addr = request.getParameter("addr");
				String role = request.getParameter("role");
				
				User user = new User(email, addr, pass, phone, role);
				
				//request.setAttribute("user", user);
				LoginCRUD crud = new LoginCRUD();
				int result = 0;
				try {
					result = crud.registerUser(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("result2", result);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}

}
