package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(
		urlPatterns = {"/04_main.jsp"},
		servletNames = {"ViewImageServlet"}
		)
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id != null) {
			chain.doFilter(request, response);
		}else {
			HttpServletResponse res = (HttpServletResponse)response;
			String appPath = req.getContextPath();
			
			Map<String, Object> map = new HashMap<>();
			map.put("reason", "로그인이 필요");
			map.put("target", getTarget(req));
			session.setAttribute("flash", map);
			
			res.sendRedirect(appPath+"/login");
		}
		// pass the request along the filter chain
		
	}
	
	private String getTarget(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String param = req.getQueryString();
		String target = param == null ? uri:uri + "?" + param;
		return target;
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
