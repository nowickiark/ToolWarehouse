package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"ToolsServlet"})
public class AuthFilter implements Filter {


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;

        if(httpServletRequest.getSession().getAttribute("login") != null ){
            filterChain.doFilter(req, resp);
        } else {
            httpServletRequest.getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }


    }
}
