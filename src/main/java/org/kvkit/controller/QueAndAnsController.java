package org.kvkit.controller;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kvkit.hibernate.QueNAnsHibernate;
import org.kvkit.model.QuesAns;

@Path("/")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class QueAndAnsController {
	
	QueNAnsHibernate qHiber = new QueNAnsHibernate();
	String queryString = "FROM QuesAns";
	
	@Path("/getAllQueAns")
	@GET
	public List<QuesAns> getAllQueAns() {
		Collection<QuesAns> queList = qHiber.getAllQueNAns(queryString);
		System.out.println("queList --> "+queList.size());
		return (List<QuesAns>) queList;
	}
	
	@GET
	@Path("/getDisplayQueAns/{displayFilter}")
	public List<QuesAns> getDisplayQueAns(@PathParam(value="displayFilter") String displayFilter) {
		Collection<QuesAns> queList = qHiber.getAllQueNAns(queryString + " where display = "+displayFilter);
		System.out.println("queList --> "+queList.size());
		return (List<QuesAns>) queList;
	}
	
	@Path("/addQueAns")
	@PUT
	public Response addQueAns(List<QuesAns> quesAnss) {
		qHiber.saveOrUpdateQueAns(quesAnss);
		return Response.created(null).entity("Object Created").build();
	}
	
	@Path("/updateQueAns")
	@POST
	public Response updateQueAns(List<QuesAns> quesAnss) {
		qHiber.saveOrUpdateQueAns(quesAnss);
		return Response.noContent().build();
	}
	
	@Path("/deleteQueAns")
	@DELETE
	public Response deleteQueAns(@QueryParam(value="id") Integer queIds) {
		System.out.println("queIds - "+queIds);
		qHiber.deleteQueAns(queIds.toString());
		return Response.noContent().build();
	}
	
	@Path("/deleteQueAns/{id}")
	@DELETE
	public Response deleteTestQueAns(@PathParam(value = "id") List<Integer> queIds) {
		System.out.println("queIds - "+queIds);
		qHiber.deleteQueAns(queIds.toString());
		return Response.noContent().build();
	}

}
