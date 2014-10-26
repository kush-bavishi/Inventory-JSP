package com.kush.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kush.model.entity.Item;

public class ItemCRUD
{
	private Connection conn = null;
	private PreparedStatement vieStmt = null;
	private PreparedStatement insStmt = null;
	private PreparedStatement updStmt = null;
	private PreparedStatement delStmt = null;
	private PreparedStatement serStmt = null;
	private PreparedStatement serByIdStmt = null;

	public ItemCRUD()
	{
		conn = new ConnectionDAO().doConnect();
		if (conn != null)
		{
			try
			{
				vieStmt = conn.prepareStatement("select * from Items");
				insStmt = conn
						.prepareStatement("insert into Items values(?,?,?,?,?,?,?,?,?,?,?)");
				updStmt = conn
						.prepareStatement("update Items set ItemName=?, ItemManufacturer=?, ItemType=?, ItemDescription=?, ItemQuantity=?, ItemRating=?, ItemColor=?, ItemPrice=? where ItemId=?");
				delStmt = conn
						.prepareStatement("delete from Items where ItemId=?");
				serStmt = conn
						.prepareStatement("select * from Items where ItemName=?");
				serByIdStmt = conn.prepareStatement("select * from Items where ItemId=?");
				
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Item> viewItem()
	{
		ArrayList<Item> list = null;
		if(vieStmt != null)
		{
			try
			{
				list = new ArrayList<Item>();
				ResultSet result = vieStmt.executeQuery();
				while(result.next())
				{
					String id = result.getString(1);
					String name = result.getString(2);
					String manufacturer = result.getString(3);
					String type = result.getString(4);
					String description = result.getString(5);
					int quantity = result.getInt(6);
					float rating = result.getFloat(7);
					String color = result.getString(8);
					double price = result.getDouble(9);
					String imageName = result.getString(10);
					byte[] imageData = result.getBytes(11);
					list.add(new Item(id, name, manufacturer, type, description, quantity, rating, color, price, imageName, imageData));
				}
				vieStmt.close();
				conn.close();
			}
			catch (Exception e) {
				
			}
		}
		return list;
	}
	
	public int addItem(Item item) throws SQLException
	{
		System.out.println("Entered addItem");
		int result = 0;
		if(insStmt != null)
		{
			try
			{
				System.out.println("entered try");
				insStmt.setString(1, item.getItemId());
				System.out.println("id");
				insStmt.setString(2, item.getItemName());
				System.out.println("name");
				insStmt.setString(3, item.getItemManufacturer());
				System.out.println("manufacturer");
				insStmt.setString(4, item.getItemType());
				System.out.println("type");
				insStmt.setString(5, item.getItemDescription());
				System.out.println("description");
				insStmt.setInt(6, item.getItemQuantity());
				System.out.println("quantity");
				insStmt.setFloat(7, item.getItemRating());
				System.out.println("rating");
				insStmt.setString(8, item.getItemColor());
				System.out.println("color");
				insStmt.setDouble(9, item.getItemPrice());
				System.out.println("price");
				insStmt.setString(10, item.getItemImageName());
				System.out.println("iamge name");
				insStmt.setBytes(11, item.getItemImageData());
				System.out.println("iamge data");
				
				result = insStmt.executeUpdate();
				System.out.println("result = " + result);
				conn.commit();
				insStmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
				System.out.println("Entered catch");
				System.out.println(e);
				e.printStackTrace();
				conn.rollback();
			}
		}
		return result;
	}
	
	/*public int updateItem(Item item)
	{
		int result = 0;
		if(updStmt != null)
		{
			try
			{
				updStmt.setString(1, item.getItemName());
				updStmt.setString(2, item.getItemManufacturer());
				updStmt.setString(3, item.getItemType());
				updStmt.setString(4, item.getItemDescription());
				updStmt.setInt(5, item.getItemQuantity());
				updStmt.setFloat(6, item.getItemRating());
				updStmt.setString(7, item.getItemColor());
				updStmt.setDouble(8, item.getItemPrice());
				
				result = updStmt.executeUpdate();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}*/
	
	public ArrayList<Item> searchItem(String query) throws SQLException
	{
		ArrayList<Item> list = null;
		if (serStmt != null) {
			try {
				list = new ArrayList<Item>();
				serStmt.setString(1, query);
				ResultSet result = serStmt.executeQuery();
				while (result.next()) {
					String id = result.getString(1);
					String name = result.getString(2);
					String manufacturer = result.getString(3);
					String type = result.getString(4);
					String description = result.getString(5);
					int quantity = result.getInt(6);
					float rating = result.getFloat(7);
					String color = result.getString(8);
					double price = result.getDouble(9);
					String imageName = result.getString(10);
					byte[] imageData = result.getBytes(11);
					list.add(new Item(id, name, manufacturer, type, description, quantity, rating, color, price, imageName, imageData));
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			serStmt.close();
			conn.close();
		}
		return list;
	}
	
	public Item searchItemById(String query) throws SQLException
	{
		Item item = null;
		if (serByIdStmt != null) {
			try {
				//list = new ArrayList<Item>();
				serByIdStmt.setString(1, query);
				ResultSet result = serByIdStmt.executeQuery();
				while (result.next()) {
					String id = result.getString(1);
					String name = result.getString(2);
					String manufacturer = result.getString(3);
					String type = result.getString(4);
					String description = result.getString(5);
					int quantity = result.getInt(6);
					float rating = result.getFloat(7);
					String color = result.getString(8);
					double price = result.getDouble(9);
					String imageName = result.getString(10);
					byte[] imageData = result.getBytes(11);
					item = new Item(id, name, manufacturer, type, description, quantity, rating, color, price, imageName, imageData);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			serByIdStmt.close();
			conn.close();
		}
		return item;
	}

	public int deleteItem(String id) throws SQLException
	{
		int result = 0;
		if (delStmt != null) {
			try {
				delStmt.setString(1, id);
				result = delStmt.executeUpdate();
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				conn.rollback();
			}
		}
		return result;
	}
	
}
