package interview.jettyjersytutorial;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by abhay on 08/12/17.
 */
  @Path("home")
  public class Resource {
  @GET
  @Path("hello")
  @Produces(MediaType.TEXT_PLAIN)
  public String helloWorld() {
    return "Hello, world!";
  }

  @GET
  @Path("path/{var}")
  @Produces(MediaType.TEXT_PLAIN)
  public String pathMethod(@PathParam("var") String name) {
    return "Hello," + name;
  }

  @POST
  @Path("post")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.TEXT_HTML)
  public String postMethod(@FormParam("name") String name) {
    return "<h2>Hello, " + name + "</h2>";
  }
}



