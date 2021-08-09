/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Admin
 */
@WebFilter(filterName = "ControllerFilter", urlPatterns = {"/*"})
public class ControllerFilter implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public ControllerFilter() {
    }    
    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
//
        String uri = req.getRequestURI();
        String url = "login.jsp";
        try {
            int lastIndex = uri.lastIndexOf("/");
            String resource = uri.substring(lastIndex + 1);
           // System.out.println(resource);
            if (resource.length() > 0) {
                url = resource;
                if(resource.lastIndexOf(".jsp") > 0){
                    String[] tmp = resource.split(".jsp");
                    url = tmp[0].substring(0,1).toUpperCase() + tmp[0].substring(1) + "Controller";
                }
            }
            if (url != null) {
//                System.out.println(url);
                req.getRequestDispatcher(url).forward(request, response);

            } else {
                chain.doFilter(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {        
        
    }

    
    
}
