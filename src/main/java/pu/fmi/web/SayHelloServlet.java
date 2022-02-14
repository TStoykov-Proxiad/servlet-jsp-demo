package pu.fmi.web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/say-hello2")
public class SayHelloServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String name = req.getParameter("name");

    // resp.setCharacterEncoding("UTF-8");
    // resp.setContentType("text/html");
    resp.setHeader("content-type", "text/html;charset=utf-8");
    String greeting = (String) getServletContext().getAttribute("greeting");
    resp.getWriter().write("<html><body>" + greeting + " chicken " + name + "</body></html>");
  }
}
