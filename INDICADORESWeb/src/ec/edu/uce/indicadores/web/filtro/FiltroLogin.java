package ec.edu.uce.indicadores.web.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FiltroLogin implements Filter{



	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		// Get the loginBean from session attribute
         
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		HttpSession session = httpServletRequest.getSession();
		String pageRequested = httpServletRequest.getRequestURL().toString();
		httpServletRequest.setCharacterEncoding("UTF-8");        
        
		if (httpServletRequest.getServletPath().contains("/public/login.xhtml") || httpServletRequest.getServletPath().contains("/javax.faces.resource")) {
			filterChain.doFilter(request, response);
		} else {
			if(session.getAttribute("UsuarioDTO") == null && !pageRequested.contains("/public/login.xhtml")){
				httpServletResponse.sendRedirect(
						new StringBuilder().append(httpServletRequest.getContextPath()).append("/public/login.xhtml").toString());
			}else{
				filterChain.doFilter(request, response);				
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
