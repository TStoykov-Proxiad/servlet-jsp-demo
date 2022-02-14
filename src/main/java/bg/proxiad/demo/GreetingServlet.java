package bg.proxiad.demo;

import static java.lang.String.format;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/count-all-requess")
public class GreetingServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("name");
    String greeting = "Здравей";

    Long allCount = (Long) getServletContext().getAttribute(ReqCountingFilter.COUNTER_ATTR);

    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter()
        .append(
            format(
                "<html><body><h1>%s, %s</h1><p>Counter: %s</p></body></html>",
                greeting, name, allCount));
  }
}
