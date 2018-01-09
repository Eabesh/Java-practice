package interview.jettyjersytutorial;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Created by abhay on 08/12/17.
 */
public class App {
  public static void main(String[] args) {
    ResourceConfig config = new ResourceConfig();
    config.packages("interview.jettyjersytutorial");
    ServletHolder jerseyServlet = new ServletHolder(new ServletContainer(config));
    Server server = new Server(8081);
    ServletContextHandler context = new ServletContextHandler(server, "/");
    context.addServlet(jerseyServlet, "/*");
    try {
      server.start();
      server.join();

    } catch (Exception e) {
      System.out.println(e);
      server.destroy();
    }
  }
}
