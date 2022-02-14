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
  private Long myCount = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getSession().getId();
    String greeting = "Здравей";
    if (req.getAttribute("localCount") == null) {
      req.setAttribute("localCount", 1);
    } else {
      myCount = (Long) req.getSession().getAttribute("localCount");
      req.getSession().setAttribute("localCount", myCount + 1);
    }

    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter()
        .append(
            format(
                "<html><body><h1>%s, %s</h1><p>My Counter: %s</p></body></html>",
                greeting, name, myCount));
  }
}
