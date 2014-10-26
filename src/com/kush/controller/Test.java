package com.kush.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.kush.model.dao.ItemCRUD;
import com.kush.model.entity.Item;

public class Test
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1. Add\n2. View\n3. Exit");
		int x = Integer.parseInt(br.readLine());
		while(x != 3)
		{
			switch(x)
			{
			case 1:
				System.out.print("Enter id : ");
				String id = br.readLine();
				
				System.out.print("Enter name : ");
				String name = br.readLine();
				
				System.out.print("Enter manufacturer : ");
				String manufacturer = br.readLine();
				
				System.out.print("Enter type : ");
				String type = br.readLine();
				
				System.out.print("Enter description : ");
				String description = br.readLine();
				
				System.out.print("Enter quantity : ");
				int quantity = Integer.parseInt(br.readLine());
				
				System.out.print("Enter color : ");
				String color = br.readLine();
				
				System.out.print("Enter price : ");
				double price = Double.parseDouble(br.readLine());
				
				float rating = 0;
				
				ItemCRUD crud = new ItemCRUD();
				//int res = crud.addItem(new Item(id, name, manufacturer, type, description, quantity, rating, color, price));
				
				//System.out.println(res + " item(s) added successfully");
				break;
				
			case 2:
				crud = new ItemCRUD();
				ArrayList<Item> list = crud.viewItem();
				if(list.size() != 0)
				{
					for(Item i: list)
					{
						System.out.println("Id : " + i.getItemId());
						System.out.println("Name : " + i.getItemName());
						System.out.println("Manufacturer : " + i.getItemManufacturer());
						System.out.println("Type : " + i.getItemType());
						System.out.println("Description : " + i.getItemDescription());
						System.out.println("Quantity : " + i.getItemQuantity());
						System.out.println("Rating : " + i.getItemRating());
						System.out.println("Price : " + i.getItemPrice());
						System.out.println("Color : " + i.getItemColor());
						System.out.println();					
					}
				}
				else
					System.out.println("Sorry, no records found");
				break;
			}
			x = Integer.parseInt(br.readLine());
		}
	}
}
