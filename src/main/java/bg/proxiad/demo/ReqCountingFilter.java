package bg.proxiad.demo;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class ReqCountingFilter implements Filter {

  public static final String COUNTER_ATTR = "counter";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    filterConfig.getServletContext().setAttribute(COUNTER_ATTR, Long.valueOf(0L));
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    Long allCount = (Long) request.getServletContext().getAttribute(COUNTER_ATTR);
    allCount++;
    request.getServletContext().setAttribute(COUNTER_ATTR, allCount);

    HttpSession session = ((HttpServletRequest) request).getSession();
    long count = 0L;
    if (session.getAttribute("count") != null) {
      count = (long) session.getAttribute("count");
    }
    session.setAttribute("count", count + 1);

    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    System.out.println("MyFirstFilter, destroing");
  }
}
