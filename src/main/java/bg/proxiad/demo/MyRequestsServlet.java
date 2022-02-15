package bg.proxiad.demo;

import static java.lang.String.format;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/count-my-requests")
public class MyRequestsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getSession().getId();
    String greeting = "Здравей";
    long count = (long) (req.getSession().getAttribute("count"));
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter()
        .append(
            format(
                "<html><body><h1>%s, %s</h1><p>Counter: %s</p></body></html>",
                greeting, name, count));
  }
}
