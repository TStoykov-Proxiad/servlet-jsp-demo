package pu.fmi.web;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello-jsp")
public class SayHelloThroughJspServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String name = req.getParameter("name");
    req.setAttribute("name", name);
    String greeting = (String) getServletContext().getAttribute("greeting");
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/say-hello.jsp");
    dispatcher.forward(req, resp);
  }
}
