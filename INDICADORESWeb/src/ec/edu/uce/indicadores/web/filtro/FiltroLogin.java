package ec.edu.uce.indicadores.web.filtro;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

public class FiltroLogin implements Filter{

	private FilterConfig filterConfig;


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
				if (validarUrlPermitida(session, pageRequested)) 
					filterChain.doFilter(request, response);
				else
					httpServletResponse.sendRedirect(
							new StringBuilder().append(httpServletRequest.getContextPath()).append("/public/login.xhtml").toString());					
			}
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.filterConfig = null;
	}
	
	/**
	 * @return the filterConfig
	 */
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	/**
	 * @param filterConfig the filterConfig to set
	 */
	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}
	
	@SuppressWarnings("unchecked")
	private Boolean validarUrlPermitida (HttpSession session, final String pageRequested) {
		
		Map<Integer, String> mapMenuUsuario = (Map<Integer, String>) session.getAttribute("menuUsuario");
		
		Collection<String> urlUsuarioCol = mapMenuUsuario.values();
		
		Collection<String> urlUsuarioPermitida = CollectionUtils.select(urlUsuarioCol, new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				return pageRequested.contains(String.valueOf(arg0));
			}
		});
		
		if (CollectionUtils.isNotEmpty(urlUsuarioPermitida)) {
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}
}
