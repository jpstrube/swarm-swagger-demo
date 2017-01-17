package net.struwi.swarmswaggerdemo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/hello")
@Api(value = "hello")
public class HelloWorldEndpoint {

	@GET
	@Produces("text/plain")
    @ApiOperation(value = "Say hello", response = String.class)
    public Response doGet() {
		return Response.ok("Hello from WildFly Swarm!").build();
	}
}
