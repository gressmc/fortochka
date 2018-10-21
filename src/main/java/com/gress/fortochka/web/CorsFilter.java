package com.gress.fortochka.web;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Roman_Radetskiy.
 */
@Component
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //nothing to initialize
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //nothing to release
    }
}
