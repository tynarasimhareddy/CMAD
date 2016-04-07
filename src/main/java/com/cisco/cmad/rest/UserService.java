package com.cisco.cmad.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/user")
public class UserService {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<String> getUsers(){
		List<String> users = new ArrayList<String>();
		users.add("Narasimha Reddy");
		users.add("NTY");
		users.add("Reddy");
		return users;
	}
}
