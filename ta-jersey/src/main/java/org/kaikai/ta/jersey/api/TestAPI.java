package org.kaikai.ta.jersey.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by kaicao on 07/11/15.
 */
@Path("/test")
public class TestAPI {

  private static final Logger LOG = LoggerFactory.getLogger(TestAPI.class);

  @GET
  @Path("1")
  @Produces(MediaType.APPLICATION_JSON)
  public Response test() {
    LOG.debug("test called");
    return Response.ok(new ABC(1, "abc")).build();
  }

  // works with public static private, without default constructor, no getter/setter
  private class ABC {
    public int id;
    public String name;

    public ABC(int id, String name) {
      this.id = id;
      this.name = name;
    }
  }
}
