package com.kush.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kush.model.dao.ItemCRUD;
import com.kush.model.entity.Item;

/**
 * Servlet implementation class FileUploadController
 */
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entered FileUploadController");
		int result = 0;
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Set factory constraints
		factory.setSizeThreshold(200000000);
		File upLoadFile = new File(getServletContext().getRealPath("/"));
		factory.setRepository(upLoadFile);
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// Set overall request size constraint
		upload.setSizeMax(200000000);// Parse the request
		try {
			String name = "", id = "", manu = "", filename = "", type = "", desc = "", color = "";
			double price = 0.0;
			int quan = 0;
			byte content1[] = null;
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();
				if (item.isFormField()) {
					if (id.length() == 0)
						id = item.getString();
					else if (name.length() == 0)
						name = item.getString();
					else if(manu.length()==0)
						manu = item.getString();
					else if(type.length() == 0)
						type = item.getString();
					else if(desc.length() == 0)
						desc = item.getString();
					else if(quan == 0)
						quan = Integer.parseInt(item.getString());
					else if(color.length() == 0)
						color = item.getString();
					else if(price == 0)
						price = Double.parseDouble(item.getString());
				} else {
					if (content1 == null) {
						content1 = item.get();
						filename = item.getName();
						filename = filename.substring(filename.lastIndexOf("\\")+1);
					}
				}
			}
			Item item = new Item(id, name, manu, type, desc, quan, 0.0f, color, price, filename, content1);
			ItemCRUD crud=new ItemCRUD();
			System.out.println("Passing to ItemCRUD");
			result = crud.addItem(item);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("Admin.jsp").forward(request, response);
	}

}
