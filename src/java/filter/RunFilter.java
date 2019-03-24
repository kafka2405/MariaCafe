package filter;

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

@WebFilter(urlPatterns = {"/homepage.jsp","/listCake.jsp","/location.jsp"})
public class RunFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String servletPath = httpRequest.getServletPath();
        if(servletPath.contains("homepage.jsp")) httpResponse.sendRedirect("homeController");
        if(servletPath.contains("listCake.jsp")) httpResponse.sendRedirect("menuController");
        if(servletPath.contains("location.jsp")) httpResponse.sendRedirect("findUsController");
    }

    @Override
    public void destroy() {
        
    }
    
}
