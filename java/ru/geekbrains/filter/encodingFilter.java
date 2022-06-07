package ru.geekbrains.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

public class encodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.getWriter().println("Header");

        filterChain.doFilter(servletRequest, servletResponse);

        servletResponse.getWriter().println("Footer");
    }
}
