package bg.proxiad.demo;

import static java.lang.String.format;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class GreetingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String greeting = "Здравей";

		Long allCount = (Long) getServletContext().getAttribute(ReqCountingFilter.COUNTER_ATTR);

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().append(
				format("<html><body><h1>%s, %s</h1><p>Counter: %s</p></body></html>", greeting, name, allCount));
	}

}
