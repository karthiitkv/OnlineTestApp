package org.kvkit.controller;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kvkit.hibernate.QueNAnsHibernate;
import org.kvkit.model.QuesAns;

@Path("/")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class QueAndAnsController {
	
	QueNAnsHibernate qHiber = new QueNAnsHibernate();
	
	@Path("/getAllQueAns")
	@GET
	public List<QuesAns> getAllQueAns() {
		Collection<QuesAns> queList = qHiber.getQueNAns();
		System.out.println("queList --> "+queList.size());
		return (List<QuesAns>) queList;
	}
	
	@Path("/addQueAns")
	@PUT
	public Response addQueAns(List<QuesAns> quesAnss) {
		qHiber.addQueAns(quesAnss);
		return Response.created(null).entity("Object Created").build();
	}

}
