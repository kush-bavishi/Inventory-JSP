package com.kush.model.bs;

import com.kush.model.dao.LoginCRUD;

public class ItemManagement {

	public String userLogin(String user,String password){
		LoginCRUD crud=new LoginCRUD();
		return crud.checkLogin(user, password);
	}
	
}
