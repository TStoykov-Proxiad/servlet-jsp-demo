package bg.proxiad.demo;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/say-hello-my-way", name = "SayHelloMyWay")
// initParams = {@WebInitParam(name = "initGreeting", value = "Hello there,")})
public class SayHelloMyWay extends HttpServlet {
  private String greeting;

  @Override
  public void init() throws ServletException {
    greeting = getServletConfig().getInitParameter("initGreeting");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("name");
    resp.getWriter().write(greeting + ", " + name + "!");
  }
}
