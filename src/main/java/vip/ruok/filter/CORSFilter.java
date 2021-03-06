package com.tmk.Filter;

import javax.servlet.*;
import java.io.IOException;
import  javax.servlet.http.HttpServletResponse;

public  class  CORSFilter  implements  Filter {

    @Override
    public  void  init(FilterConfig filterConfig)  throws  ServletException {

    }

    @Override
    public  void  doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)  throws  IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.addHeader( "Access-Control-Allow-Origin" ,  "*" );
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public  void  destroy() {

    }
}
