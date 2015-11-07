package org.kaikai.ta.jersey;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.server.ResourceConfig;
import org.kaikai.ta.jersey.provider.ObjectMapperProvider;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by kaicao on 07/11/15.
 */
public class App {

  public static void main(String[] args) throws Exception {
    ResourceConfig application = new ResourceConfig()
        .packages("org/kaikai/ta/jersey/api")
        .register(ObjectMapperProvider.class)
        .register(JacksonFeature.class);

    URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
    Server jettyServer = JettyHttpContainerFactory.createServer(baseUri, application);

    try {
      jettyServer.start();
      jettyServer.join();
    } finally {
      jettyServer.destroy();
    }
  }
}
