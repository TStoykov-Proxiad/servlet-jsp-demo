package bg.proxiad.demo;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/say-hello-my-way-through-jsp",
    initParams = {@WebInitParam(name = "greeting", value = "hi there")})
public class SayHelloMyWayJSP extends HttpServlet {
  private String greeting;

  @Override
  public void init() throws ServletException {
    greeting = getServletConfig().getInitParameter("greeting");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("greeting", greeting);
    RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher("/say-hello-my-way.jsp");
    dispatcher.forward(req, resp);
  }
}
