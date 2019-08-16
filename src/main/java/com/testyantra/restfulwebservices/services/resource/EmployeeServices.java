package com.testyantra.restfulwebservices.services.resource;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.testyantra.restfulwebservices.dao.EmployeeDAO;
import com.testyantra.restfulwebservices.dto.EmployeeBean;
import com.testyantra.restfulwebservices.dto.ResponseGenarator;

@Path("employee")
public class EmployeeServices {
	@PUT
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseGenarator createemployee(/* @BeanParam */ EmployeeBean bean) {
		ResponseGenarator response = new ResponseGenarator();
		if(new EmployeeDAO().createEmployee(bean)) {
			response.setStatus(201);
			response.setMessage("Data Added to the DB");
			response.setDiscription("for employee db the data is added");
		} else {
			response.setStatus(401);
			response.setMessage("Data not added to the DB");
			response.setDiscription("for employee db the data is not added");
		}
		return response;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("get")
	public EmployeeBean getemployee(@QueryParam("id")String id) {
		System.out.println(id);
		return new EmployeeDAO().getEmployee(id);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getall")
	public Set<EmployeeBean> getAllemployee() {
		return new EmployeeDAO().getAllEmployee();
	}
	@GET
	@Path("addcookie")
	public Response addCookie() {
		NewCookie cookie = new NewCookie("name", "Giridhar");
		return Response.ok("Cookie Added").cookie(cookie).build();
	}
	@GET
	@Path("getcookie")
	public String getCookie(@CookieParam("name") String name) {
		return name;
	}
	
	@POST
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseGenarator modifyemployee(/* @BeanParam */ EmployeeBean bean) {
		ResponseGenarator response = new ResponseGenarator();
		if(new EmployeeDAO().modifyEmployee(bean)) {
			response.setStatus(201);
			response.setMessage("Data Added to the DB");
			response.setDiscription("for employee db the data is added");
		} else {
			response.setStatus(401);
			response.setMessage("Data not added to the DB");
			response.setDiscription("for employee db the data is not added");
		}
		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete")
	public ResponseGenarator remove(String id) {
		ResponseGenarator response = new ResponseGenarator();
		if(new EmployeeDAO().removeEmployee(id)) {
			response.setStatus(201);
			response.setMessage("Data Added to the DB");
			response.setDiscription("for employee db the data is added");
		} else {
			response.setStatus(401);
			response.setMessage("Data not added to the DB");
			response.setDiscription("for employee db the data is not added");
		}
		return response;
	}
}
