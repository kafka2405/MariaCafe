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

@WebFilter(urlPatterns = {"/*"})
public class RunFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String servletPath = httpRequest.getServletPath();
            System.out.println(servletPath);
            if (servletPath.endsWith(".jsp")) {

                if (servletPath.contains("listCake.jsp")) {
                    httpResponse.sendRedirect("aboutController");
                } else if (servletPath.contains("location.jsp")) {
                    httpResponse.sendRedirect("findControler");
                } else {
                    httpResponse.sendRedirect("homeController");
                }
            }else{
                chain.doFilter(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        
    }
    
}
