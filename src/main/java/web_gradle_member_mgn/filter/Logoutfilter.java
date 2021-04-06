package web_gradle_member_mgn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Logoutfilter
 */
@WebFilter("/logoutProcess")
public class Logoutfilter implements Filter {

    public Logoutfilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		 //if the ServletRequest is an instance of HttpServletRequest  
        if(servletRequest instanceof HttpServletRequest) {  
            //cast the object  
            HttpServletRequest request = (HttpServletRequest)servletRequest;
            HttpServletResponse response = (HttpServletResponse)servletResponse;
           
            if (request.getProtocol().compareTo("HTTP/1.0") == 0) {
                response.setHeader("Pragma", "no-cache");
            } else if (request.getProtocol().compareTo("HTTP/1.1") == 0) {
                response.setHeader("Cache-Control", "no-cache");
            }
            response.setDateHeader("Expires", 1);          
              
            //continue on in the filter chain with the FakeHeaderRequest and ServletResponse objects  
            filterChain.doFilter(request, servletResponse);  
        } else {  
            //otherwise, continue on in the chain with the ServletRequest and ServletResponse objects  
            filterChain.doFilter(servletRequest, servletResponse);  
        }         
 
        return;
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
