package com.demo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	@Autowired
	LoginDAO loginDao;
	
	
	public boolean validateUser(String user, String password) {
	Users users=new Users(11,"Atul");	
			try{
				loginDao.save(users);
			} catch (Exception e) {
				System.out.println("Exception : " + e);
			}
			return user.equalsIgnoreCase("Atul") && password.equals("dummy");

}
}
