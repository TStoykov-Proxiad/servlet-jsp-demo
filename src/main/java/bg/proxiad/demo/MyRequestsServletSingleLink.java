package bg.proxiad.demo;

import static java.lang.String.format;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/count-my-requests-this-link")
public class MyRequestsServletSingleLink extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getSession().getId();
    String greeting = "Здравей";
    HttpSession session = ((HttpServletRequest) req).getSession();
    long count = 0L;
    if (session.getAttribute("localCount") != null) {
      count = (long) session.getAttribute("localCount");
    }
    session.setAttribute("localCount", count + 1);
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter()
        .append(
            format(
                "<html><body><h1>%s, %s</h1><p>Counter: %s</p></body></html>",
                greeting, name, count + 1));
  }
}
