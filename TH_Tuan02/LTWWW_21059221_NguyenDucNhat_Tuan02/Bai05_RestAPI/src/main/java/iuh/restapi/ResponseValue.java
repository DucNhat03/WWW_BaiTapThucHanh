package iuh.restapi;

import java.util.Collections;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/eventValue")
public class ResponseValue {

	// Endpoint: /api/v1/eventValue/{intVal} ->Path param
	// Endpoint: /api/v1/eventValue/{intVal}?key1=value1 ->/Path param?query param
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{intVal}")
	public Response testValue(@PathParam("intVal") int value) {
		if (value % 2 ==0) {
			return Response.ok("Value is a correct even number", MediaType.TEXT_PLAIN).build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@GET
	@Path("/add/{a}/{b}")
	public int doAdd(@DefaultValue("0") @PathParam("a") int a, @DefaultValue("0") @PathParam("b") int b) {
		return a + b + 1;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/mul")
	public int doMul(@DefaultValue("1") @QueryParam("a") int a,@DefaultValue("1") @QueryParam("b") int b) {
		return a * b;
	}
}
