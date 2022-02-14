package bg.proxiad.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

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

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("MyFirstFilter, destroing");
	}

}
