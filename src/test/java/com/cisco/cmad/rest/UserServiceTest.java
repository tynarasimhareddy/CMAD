package com.cisco.cmad.rest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.cisco.cmad.dao.UsersDao;

public class UserServiceTest {

	@Test(expected=IllegalArgumentException.class)
	public void testGetUser(){
		UsersDao usersDaoMock = Mockito.mock(UsersDao.class);
		Users u = new Users();
		u.setName("Narasimha");
		u.setId(1);
		Mockito.when(usersDaoMock.getUser(Mockito.anyInt())).thenReturn(u);
		
		UserService service = new UserService();
		service.setUserDao(usersDaoMock);
		
		Users result = service.getUser(1);
		
		Assert.assertEquals("Narasimha", result.getName());
		
		Mockito.when(usersDaoMock.getUser(null)).thenThrow(new IllegalArgumentException("ID cannot be null"));
		result = service.getUser(null);
		
	}
	
	/*@Test(expected=IllegalArgumentException.class)
	public void testGetUserWithNullAsId(){
		UsersDao usersDaoMock = Mockito.mock(UsersDao.class);
		Mockito.when(usersDaoMock.getUser(null)).thenThrow(new IllegalArgumentException("ID cannot be null"));
		UserService service = new UserService();
		service.setUserDao(usersDaoMock);
		Users result = service.getUser(null);
	}*/
}
